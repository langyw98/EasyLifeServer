package cn.bdqn;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import cn.bdqn.dao.FavorDao;
import cn.bdqn.dao.RecommendDao;
import cn.bdqn.dao.impl.CommentDaoImpl;
import cn.bdqn.dao.impl.FavorDaoImpl;
import cn.bdqn.dao.impl.MovieDaoImpl;
import cn.bdqn.dao.impl.MovieWillDaoImpl;
import cn.bdqn.dao.impl.RecommendDaoImpl;
import cn.bdqn.dao.impl.UserDaoImpl;
import cn.bdqn.domain.Comment;
import cn.bdqn.domain.Favor;
import cn.bdqn.domain.Movie;
import cn.bdqn.domain.Recommend;
import cn.bdqn.domain.User;
import cn.bdqn.util.FileUtil;

/**��������*/
public class DealCMD extends HttpServlet {
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String cmdStr = request.getParameter("cmd");
		int cmd = Integer.parseInt(cmdStr);
		
		OutputStream outStream = response.getOutputStream();
		byte[] data = null;
		String result = null;
		boolean flag = false;
		switch(cmd){
		case 0://��¼
			String uid = request.getParameter("uid");
			String login = request.getParameter("login");
			UserDaoImpl userDaoImpl= new UserDaoImpl();
			flag = userDaoImpl.getUser(uid);
			if(!flag){
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				uid = userDaoImpl.getUser(name, password);
				if(uid != null){
					flag = true;
				}
			}
			if(flag){
				String nickName = userDaoImpl.getNickName(uid);
				result = "{'cmd':'"+0+"','code':'"+0+"','uid':'"+uid+"','login':'"+login+"','nickname':'"+nickName+"'}";
			}else{
				result = "{'cmd':'"+0+"','code':'"+1+"',login:'"+login+"'}";
			}
			break;
		case 1://ע��
			User user = new User();
			user.setName(request.getParameter("name"));
			user.setPassword(request.getParameter("password"));
			UserDaoImpl userDaoRe= new UserDaoImpl();
			String userid = null;
			if(userDaoRe.isExist(user.getName())){
				flag = false;
			}else{
				userid = UUID.randomUUID().toString();
				user.setUid(userid);
				flag = userDaoRe.insertUser(user);
			}
			if(flag){
				result = "{'cmd':'"+1+"','code':'"+0+"','uid':'"+userid+"'}";
			}else{
				result = "{'cmd':'"+1+"','code':'"+1+"'}";
			}
			break;
		case 2://��ȡ����
			String type = request.getParameter("type");
			String tid = request.getParameter("tid");
			String start = request.getParameter("startPos");
			String pageLength = request.getParameter("pageLength");
			CommentDaoImpl recImpl = new CommentDaoImpl();
			List<Comment> recs = recImpl.getComments(Integer.parseInt(type),Integer.parseInt(tid), Integer.parseInt(start) ,Integer.parseInt(pageLength));
			if(recs !=null && recs.size()>0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<recs.size();i++){
					Comment rec = recs.get(i);
					sb.append("{'name':'"+rec.getUsername()+"','time':'"+rec.getTime()+"','recid':'"+rec.getRecid()+
							"','content':'"+rec.getContent()+"','type':'"+rec.getType()+"','tid':'"+rec.getTid()+"'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+2+"','code':'"+0+"'"+sb.toString()+"}";
			}else if(recs != null && recs.size() == 0){
				result = "{'cmd':'"+2+"','code':'"+2+"'}";
			}else{
				result = "{'cmd':'"+2+"','code':'"+1+"'}";
			}
			break;
		case 3://��������
			String name = request.getParameter("name");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String time = format.format(new Date());
			String content = request.getParameter("content");
			String type2 = request.getParameter("type");
			String tid2 = request.getParameter("tid");
			CommentDaoImpl recImpl2 = new CommentDaoImpl();
			Comment rec = new Comment();
			rec.setUsername(name);
			rec.setContent(content);
			rec.setTime(time);
			rec.setTid(Integer.parseInt(tid2));
			rec.setType(Integer.parseInt(type2));
			flag = recImpl2.insertCom(rec);
			if(flag){
				result = "{'cmd':'"+3+"','code':'"+ 0 +
						"','name':'"+rec.getUsername()+"','time':'"+rec.getTime()+"','recid':'"+rec.getRecid()+
						"','content':'"+rec.getContent()+"','type':'"+rec.getType()+"','tid':'"+rec.getTid()+"'}";
			}else{
				result = "{'cmd':'"+3+"','code':'"+1+"'}";
			}
			break;
		case 4://��ȡͼƬ
			String imagename = request.getParameter("image");
			String projectPath = request.getSession().getServletContext().getRealPath("") ;
			try{
				data = FileUtil.readFile(projectPath, imagename);
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		case 5://�ϴ�ͷ��ͼƬ
			boolean isMultipart = ServletFileUpload.isMultipartContent(request); 
			uid = request.getParameter("uid");
	        
			if (isMultipart) {  
	            FileItemFactory factory = new DiskFileItemFactory();  
	            ServletFileUpload upload = new ServletFileUpload(factory);  
	            try {  
	                List items = upload.parseRequest(new ServletRequestContext(request));  
	                Iterator iter = items.iterator();  
	                while (iter.hasNext()) {  
	                    FileItem item = (FileItem) iter.next();  
	                    //�ϴ��ļ���Ϣ����  
	                    data = item.get();  
	                    projectPath = request.getSession().getServletContext().getRealPath("") ;
	                    String filePath = projectPath + "/uploadimages/" + uid + ".png";  
	                    FileOutputStream fos = new FileOutputStream(filePath);  
	                    fos.write(data);  
	                    fos.close(); 
	                }  
	            } catch (FileUploadException e) {  
	                e.printStackTrace();  
	            }  
	        } 
			break;
		case 6://��ȡͷ��ͼƬ
			uid = request.getParameter("uid");
			projectPath = request.getSession().getServletContext().getRealPath("") ;
			try{
				data = FileUtil.readHeadIcon(projectPath, uid);
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		case 7://�޸�����
			uid = request.getParameter("uid");
			String oldpwd = request.getParameter("oldpwd");
			String newpwd = request.getParameter("newpwd");
			userDaoImpl = new UserDaoImpl();
			boolean isSuccess = userDaoImpl.updatePwd(uid, oldpwd, newpwd);
			if(isSuccess){
				result = "{'cmd':'"+7+"','code':'"+0+"'}";
			}else{
				result = "{'cmd':'"+7+"','code':'"+1+"'}";
			}
			break;
		case 8://�޸��ǳ�
			uid = request.getParameter("uid");
			String nickname = request.getParameter("nickname");
			userDaoImpl = new UserDaoImpl();
			isSuccess = userDaoImpl.updateNickname(uid, nickname);
			if(isSuccess){
				result = "{'cmd':'"+8+"','code':'"+0+"'}";
			}else{
				result = "{'cmd':'"+8+"','code':'"+1+"'}";
			}
			break;
		case 101://��ȡ��Ӱ�б�
			int startPos = Integer.parseInt(request.getParameter("startPos"));
			MovieDaoImpl movieImpl = new MovieDaoImpl();
			List<Movie> movies = movieImpl.getMovie(startPos);
			if(movies != null && movies.size() > 0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<movies.size();i++){
					Movie movie = movies.get(i);
					
					sb.append("{'mid':'"+movie.getMovieid()+"','name':'"+movie.getName()+"','type':'"+movie.getType()+"','time':'"+movie.getTime()+"','player':'"+movie.getPlayer()+"','image':'"+movie.getImagename()+"','desc':'"+movie.getDesc()+"','tlong':'"+movie.getTimelong()+"'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+101+"','code':'"+0+"'"+sb.toString()+"}";
			}else if(movies != null && movies.size() == 0){
				result = "{'cmd':'"+801+"','code':'"+2+"'}";
			}else{
				result = "{'cmd':'"+101+"','code':'"+1+"'}";
			}
			break;
		case 102://��ȡ��Ӱ����
			String mid = request.getParameter("mid");
			MovieDaoImpl movieDI = new MovieDaoImpl();
			Movie movie = movieDI.getMovieDetails(Integer.parseInt(mid));
			if(movie != null){
				result = "{'cmd':'"+102+"','code':'"+0+"','mid':'"+mid+"','desc':'"+movie.getDesc()+"','tlong':'"+movie.getTimelong()+"'}";
			}else{
				result = "{'cmd':'"+102+"','code':'"+1+"'}";
			}
			break;
		case 801://��ȡ������ӳ��Ӱ�б�
			MovieWillDaoImpl moviewImpl = new MovieWillDaoImpl();
			List<Movie> movs = moviewImpl.getMovie(Integer.parseInt(request.getParameter("startPos")));
			if(movs != null && movs.size() > 0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<movs.size();i++){
					Movie mov = movs.get(i);
					
					sb.append("{'mid':'"+mov.getMovieid()+"','name':'"+mov.getName()+"','type':'"+mov.getType()+"','time':'"+mov.getTime()+"','player':'"+mov.getPlayer()+"','image':'"+mov.getImagename()+"','desc':'"+mov.getDesc()+"','tlong':'"+mov.getTimelong()+"'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+801+"','code':'"+0+"'"+sb.toString()+"}";
			}else if(movs != null && movs.size() == 0){
				result = "{'cmd':'"+801+"','code':'"+2+"'}";
			}else{
				result = "{'cmd':'"+801+"','code':'"+1+"'}";
			}
			break;
		case 802://��ȡ������ӳ��Ӱ����
			String mwid = request.getParameter("mid");
			MovieWillDaoImpl moviewDI = new MovieWillDaoImpl();
			Movie movws = moviewDI.getMovieDetails(Integer.parseInt(mwid));
			if(movws != null){
				result = "{'cmd':'"+802+"','code':'"+0+"','mid':'"+movws.getMovieid()+"','desc':'"+movws.getDesc()+"','tlong':'"+movws.getTimelong()+"'}";
			}else{
				result = "{'cmd':'"+802+"','code':'"+1+"'}";
			}
			break;
		case 901://��ȡ�Ƽ��б�
			RecommendDao recommendDao = new RecommendDaoImpl();
			List<Recommend> recommends = recommendDao.getRecommendList();
			if(recommends != null && recommends.size() > 0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<recommends.size();i++){
					Recommend recommend = recommends.get(i);
					
					sb.append("{'type':'"+recommend.getType()+"','tid':'"+recommend.getTid() + "'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+901+"','code':'"+0+"'"+sb.toString()+"}";
			}else{
				result = "{'cmd':'"+901+"','code':'"+1+"'}";
			}
			break;
		case 1001://��ȡ�û����ղ��б�
			uid = request.getParameter("uid");
			FavorDao favorDao = new FavorDaoImpl();
			List<Favor> favors = favorDao.getFavorList(uid);
			if(favors != null && favors.size() > 0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<favors.size();i++){
					Favor favor = favors.get(i);
					
					sb.append("{'type':'"+favor.getType()+"','tid':'"+favor.getTid() + "'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+1001+"','code':'"+0+"'"+sb.toString()+"}";
			}else{
				result = "{'cmd':'"+1001+"','code':'"+1+"'}";
			}
			break;
		case 1002://����ղ�
			uid = request.getParameter("uid");
			type = request.getParameter("type");
			tid = request.getParameter("tid");
			favorDao = new FavorDaoImpl();
			boolean rs = favorDao.addFavor(uid, Integer.valueOf(type), Integer.valueOf(tid));
			if(rs){
				result = "{'cmd':'"+1002+"','code':'"+0+"'}";
			}else{
				result = "{'cmd':'"+1002+"','code':'"+1+"'}";
			}
			break;
		case 1003://�Ƴ��ղ�
			uid = request.getParameter("uid");
			type = request.getParameter("type");
			tid = request.getParameter("tid");
			favorDao = new FavorDaoImpl();
			rs = favorDao.removeFavor(uid, Integer.valueOf(type), Integer.valueOf(tid));
			if(rs){
				result = "{'cmd':'"+1003+"','code':'"+0+"'}";
			}else{
				result = "{'cmd':'"+1003+"','code':'"+1+"'}";
			}
			break;
		}
		System.out.println(result);
		if(result != null){
			outStream.write(result.getBytes());
		}else if(data!=null && data.length>0){
			outStream.write(data);
			System.out.println(data.toString());
		}
		outStream.close();
		outStream.flush();
	}
}

package cn.bdqn;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bdqn.dao.impl.ConcertDaoImpl;
import cn.bdqn.dao.impl.DelicaciesDaoImpl;
import cn.bdqn.dao.impl.DisplayDaoImpl;
import cn.bdqn.dao.impl.HotelDetailDaoImpl;
import cn.bdqn.dao.impl.MovieDaoImpl;
import cn.bdqn.dao.impl.MovieWillDaoImpl;
import cn.bdqn.dao.impl.MusicDaoImpl;
import cn.bdqn.dao.impl.PekingOperaDaoImpl;
import cn.bdqn.dao.impl.PlayDaoImpl;
import cn.bdqn.dao.impl.RecommendDaoImpl;
import cn.bdqn.dao.impl.UserDaoImpl;
import cn.bdqn.domain.Concert;
import cn.bdqn.domain.Delicacies;
import cn.bdqn.domain.Display;
import cn.bdqn.domain.HotelDetail;
import cn.bdqn.domain.Movie;
import cn.bdqn.domain.Music;
import cn.bdqn.domain.PekingOpera;
import cn.bdqn.domain.Play;
import cn.bdqn.domain.Recommend;
import cn.bdqn.domain.User;
import cn.bdqn.util.FileUtil;

/**处理请求*/
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
		case 0://登录
			String uid = request.getParameter("uid");
			String login = request.getParameter("login");
			UserDaoImpl userDaoImpl= new UserDaoImpl();
			flag = userDaoImpl.getUser(uid);
			if(flag){
				result = "{'cmd':'"+0+"','code':'"+0+"','uid':'"+uid+"','login':'"+login+"'}";
			}else{
				result = "{'cmd':'"+0+"','code':'"+1+"',login:'"+login+"'}";
			}
			break;
		case 1://注册
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
		case 2://获取评论
			String type = request.getParameter("type");
			String tid = request.getParameter("tid");
			String start = request.getParameter("startPos");
			String pageLength = request.getParameter("pageLength");
			RecommendDaoImpl recImpl = new RecommendDaoImpl();
			List<Recommend> recs = recImpl.getRecommends(Integer.parseInt(type),Integer.parseInt(tid), Integer.parseInt(start) ,Integer.parseInt(pageLength));
			if(recs !=null && recs.size()>0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<recs.size();i++){
					Recommend rec = recs.get(i);
					sb.append("{'name':'"+rec.getUsername()+"','time':'"+rec.getTime()+"','recid':'"+rec.getRecid()+
							"','content':'"+rec.getContent()+"','type':'"+rec.getType()+"','tid':'"+rec.getTid()+"'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+2+"','code':'"+0+"'"+sb.toString()+"}";
			}else{
				result = "{'cmd':'"+2+"','code':'"+1+"'}";
			}
			break;
		case 3://发布评论
			String name = request.getParameter("name");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String time = format.format(new Date());
			String content = request.getParameter("content");
			String type2 = request.getParameter("type");
			String tid2 = request.getParameter("tid");
			RecommendDaoImpl recImpl2 = new RecommendDaoImpl();
			Recommend rec = new Recommend();
			rec.setUsername(name);
			rec.setContent(content);
			rec.setTime(time);
			rec.setTid(Integer.parseInt(tid2));
			rec.setType(Integer.parseInt(type2));
			flag = recImpl2.insertRec(rec);
			if(flag){
				result = "{'cmd':'"+3+"','code':'"+0+"'}";
			}else{
				result = "{'cmd':'"+3+"','code':'"+1+"'}";
			}
			break;
		case 4://获取图片
			String imagename = request.getParameter("image");
			String projectPath = request.getSession().getServletContext().getRealPath("") ;
			try{
				data = FileUtil.readFile(projectPath, imagename);
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		case 101://获取电影列表
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
		case 102://获取电影详情
			String mid = request.getParameter("mid");
			MovieDaoImpl movieDI = new MovieDaoImpl();
			Movie movie = movieDI.getMovieDetails(Integer.parseInt(mid));
			if(movie != null){
				result = "{'cmd':'"+102+"','code':'"+0+"','mid':'"+mid+"','desc':'"+movie.getDesc()+"','tlong':'"+movie.getTimelong()+"'}";
			}else{
				result = "{'cmd':'"+102+"','code':'"+1+"'}";
			}
			break;
		case 201://获取演唱会列表
			ConcertDaoImpl concertDI = new ConcertDaoImpl();
			List<Concert> concerts = concertDI.getConcert();
			if(concerts != null && concerts.size() > 0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<concerts.size();i++){
					Concert concert =concerts.get(i);
					
					sb.append("{'cid':'"+concert.getConcert_id()+"','name':'"+concert.getName()+"','image':'"+concert.getImage()+"','time':'"+concert.getTim()+"','addr':'"+concert.getAddress()+"'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+201+"','code':'"+0+"'"+sb.toString()+"}";
			}else{
				result = "{'cmd':'"+201+"','code':'"+1+"'}";
			}
			break;
		case 202://获取演唱会详情
			String cid = request.getParameter("cid");
			ConcertDaoImpl conDI = new ConcertDaoImpl();
			Concert concert = conDI.getCondertDetails(Integer.parseInt(cid));
			if(concert != null){
				result = "{'cmd':'"+202+"','code':'"+0+"','call':'"+concert.getCall()+"','mapx':'"+concert.getMapx()+"','mapy':'"+concert.getMapy()+"','price':'"+concert.getPrice()+"','desc':'"+concert.getDecs()+"'}";
			 }else{
				 result = "{'cmd':'"+202+"','code':'"+1+"'}";
			 }
			break;
		case 301://获取美食列表
			DelicaciesDaoImpl deDI = new DelicaciesDaoImpl();
			List<Delicacies> delics = deDI.getDelicacies();
			if(delics !=null && delics.size() > 0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<delics.size();i++){
					Delicacies delic =delics.get(i);
					
					sb.append("{'did':'"+delic.getDelicacies_id()+"','label':'"+delic.getLabel()+"','image':'"+delic.getImagename()+"','avg':'"+delic.getAvg()+"','addr':'"+delic.getAddress()+"','name':'"+delic.getName()+"'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+301+"','code':'"+0+"'"+sb.toString()+"}";
			}else{
				result = "{'cmd':'"+301+"','code':'"+1+"'}";
			}
			break;
		case 302://获取美食详情
			String did = request.getParameter("did");
			DelicaciesDaoImpl delicDI = new DelicaciesDaoImpl();
			Delicacies delica = delicDI.getDelicaciesDetail(Integer.parseInt(did));
			HotelDetailDaoImpl hodI = new HotelDetailDaoImpl();
			List<HotelDetail> hods = hodI.getHotelDetail(Integer.parseInt(did));
			if(hods != null && hods.size() > 0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<hods.size();i++){
					HotelDetail hod =hods.get(i);
					sb.append("{'name':'"+hod.getName()+"','image':'"+hod.getImagename()+"','oprice':'"+hod.getOldprice()+"','nprice':'"+hod.getNowproce()+"'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+302+"','code':'"+0+"','did':'"+Integer.parseInt(did)+"','call':'"+delica.getCall()+"','mapx':'"+delica.getMapx()+"','mapy':'"+delica.getMapy()+"'"+sb.toString()+"}";
			}else{
				result = "{'cmd':'"+302+"','code':'"+1+"'}";
			}
			break;
		case 401://获取展览列表
			DisplayDaoImpl disDI = new DisplayDaoImpl();
			List<Display> displays = disDI.getDisplays();
			if(displays != null && displays.size() > 0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<displays.size();i++){
					Display display =displays.get(i);
					
					sb.append("{'did':'"+display.getDisplayid()+"','name':'"+display.getName()+"','time':'"+display.getTime()+"','addr':'"+display.getAddress()+"','image':'"+display.getImagename()+"'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+401+"','code':'"+0+"'"+sb.toString()+"}";
			}else{
				result = "{'cmd':'"+401+"','code':'"+1+"'}";
			}
			break;
		case 402://获取展览详情
			String disid = request.getParameter("did");
			DisplayDaoImpl dispDI = new DisplayDaoImpl();
			Display display = dispDI.getDisplayDetail(Integer.parseInt(disid));
			if(display != null){
				result = "{'cmd':'"+402+"','code':'"+0+"','host':'"+display.getHost()+"','call':'"+display.getCall()+"','desc':'"+display.getDesc()+"'}";
			}else{
				result = "{'cmd':'"+402+"','code':'"+1+"'}";
			}
			break;
		case 501://获取音乐会列表
			MusicDaoImpl musicDI = new MusicDaoImpl();
			List<Music> musics = musicDI.getMusics();
			if(musics != null && musics.size() > 0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<musics.size();i++){
					Music music =musics.get(i);
					
					sb.append("{'mid':'"+music.getMusicid()+"','name':'"+music.getName()+"','image':'"+music.getImagename()+"','time':'"+music.getTime()+"','addr':'"+music.getAddress()+"'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+501+"','code':'"+0+"'"+sb.toString()+"}";
			}else{
				result = "{'cmd':'"+501+"','code':'"+1+"'}";
			}
			break;
		case 502://获取音乐会详情
			String musid = request.getParameter("mid");
			MusicDaoImpl mDI = new MusicDaoImpl();
			Music music = mDI.getMusicDetailDao(Integer.parseInt(musid));
			if(music != null){
				result = "{'cmd':'"+502+"','code':'"+0+"','call':'"+music.getCall()+"','mapx':'"+music.getMapx()+"','mapy':'"+music.getMapy()+"','price':'"+music.getPrice()+"','desc':'"+music.getDecs()+"'}";
			 }else{
				 result = "{'cmd':'"+502+"','code':'"+1+"'}";
			 }
			break;
		case 601://获取京剧列表
			PekingOperaDaoImpl poDI = new PekingOperaDaoImpl();
			List<PekingOpera> pos = poDI.getPekingOperas();
			if(pos != null && pos.size() > 0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<pos.size();i++){
					PekingOpera po =pos.get(i);
					sb.append("{'pid':'"+po.getPekingopera_id()+"','name':'"+po.getName()+"','image':'"+po.getImage()+"','time':'"+po.getTime()+"','addr':'"+po.getAddress()+"'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+601+"','code':'"+0+"'"+sb.toString()+"}";
			}else{
				result = "{'cmd':'"+601+"','code':'"+1+"'}";
			}
			break;
		case 602://获取京剧详情
			String pid = request.getParameter("pid");
			PekingOperaDaoImpl pekDI = new PekingOperaDaoImpl();
			PekingOpera po = pekDI.getPekingOperaDetail(Integer.parseInt(pid));
			if(po != null){
				result = "{'cmd':'"+602+"','code':'"+0+"','call':'"+po.getCall()+"','mapx':'"+po.getMapx()+"','mapy':'"+po.getMapy()+"','price':'"+po.getPrice()+"','desc':'"+po.getDecs()+"'}";
			}else{
				result = "{'cmd':'"+602+"','code':'"+1+"'}";
			}
			break;
		case 701://获取话剧列表
			PlayDaoImpl playDI = new PlayDaoImpl();
			List<Play> plays = playDI.getPlays();
			if(plays != null && plays.size() > 0){
				StringBuffer sb = new StringBuffer(",'list':[");
				for(int i=0;i<plays.size();i++){
					Play play =plays.get(i);
					sb.append("{'pid':'"+play.getPlay_id()+"','name':'"+play.getName()+"','image':'"+play.getImage()+"','time':'"+play.getTime()+"','addr':'"+play.getAddress()+"'},");
				}
				sb.delete(sb.length()-1, sb.length());
				sb.append("]");
				result = "{'cmd':'"+701+"','code':'"+0+"'"+sb.toString()+"}";
			}else{
				result = "{'cmd':'"+701+"','code':'"+1+"'}";
			}
			break;
		case 702://获取话剧详情
			String playid = request.getParameter("pid");
			PlayDaoImpl pDI = new PlayDaoImpl();
			Play play = pDI.getPlayDetail(Integer.parseInt(playid));
			if(play != null){
				result = "{'cmd':'"+702+"','code':'"+0+"','call':'"+play.getCall()+"','mapx':'"+play.getMapx()+"','mapy':'"+play.getMapy()+"','price':'"+play.getPrice()+"','desc':'"+play.getDecs()+"'}";
			}else{
				result = "{'cmd':'"+702+"','code':'"+1+"'}";
			}
			break;
		case 801://获取即将上映电影列表
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
		case 802://获取即将上映电影详情
			String mwid = request.getParameter("mid");
			MovieWillDaoImpl moviewDI = new MovieWillDaoImpl();
			Movie movws = moviewDI.getMovieDetails(Integer.parseInt(mwid));
			if(movws != null){
				result = "{'cmd':'"+802+"','code':'"+0+"','mid':'"+movws.getMovieid()+"','desc':'"+movws.getDesc()+"','tlong':'"+movws.getTimelong()+"'}";
			}else{
				result = "{'cmd':'"+802+"','code':'"+1+"'}";
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

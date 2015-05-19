/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.55-community : Database - life
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`life` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `life`;

/*Table structure for table `concert` */

DROP TABLE IF EXISTS `concert`;

CREATE TABLE `concert` (
  `concert_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `image` varchar(10) NOT NULL,
  `address` varchar(50) NOT NULL,
  `calls` varchar(15) NOT NULL,
  `mapx` varchar(25) NOT NULL,
  `mapy` varchar(25) NOT NULL,
  `price` varchar(30) NOT NULL,
  `descr` varchar(300) NOT NULL,
  PRIMARY KEY (`concert_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `concert` */

insert  into `concert`(`concert_id`,`name`,`time`,`image`,`address`,`calls`,`mapx`,`mapy`,`price`,`descr`) values (1,'邓丽君经典重现金曲交响演唱会','2012-09-29','20001','保利剧院','4006103721','39910854','116390762','280 580 880 1280','邓丽君-华语歌坛上，是一个传奇。她的歌有一种让人忘记痛苦的甜蜜，她的笑容柔得让人窒息。邓丽君在中国流行音乐史上毋庸置疑的是承前启后、开宗立派的一代大师。此次演出主办方将以重述青春作为整场音乐会的主轴，并以\"美好青春\"、\"惆怅青春\"、\"挣扎青春\"、\"感恩青春\"四个单元进行呈现，每个单元都包括多首具有鲜明感情色彩的邓丽君歌曲，演唱会舞台效果经过精心设计，绚丽多彩，原汁原味，气势恢弘'),(2,'张惠妹2012世界巡回演唱会','2012-06-30','20002','工人体育场','4006103721','39913265','116390762','180 380 580 880 1280','张惠妹最为人津津乐道的，除了持续的推出脍炙人口的歌曲外，就是她独一无二的舞台魅力，她的歌唱能量在经过15年的淬炼后，似乎还呈现更大的魅力，以一位出道15年歌手来说，依旧可以在作品和市场上引领风骚，这是属于张惠妹的传奇。选择在出道15周年开唱，张惠妹是希望为自己和歌迷再创下一个有意义的回忆，这次的演唱会初步估计还没开唱制作费已经超过2500万人民币，因为张惠妹说：虽然我唱的都是最经典的歌，但一定要给大家最新最强烈的视觉'),(3,'梁静茹北京演唱会','2012-06-30','20003','万事达中心','4006103721','39931095','116447265','280 580 880 1280','2000年，以一首《勇气》让梁静茹红遍大中华地区，从此成为\"K歌天后\"，梁静茹的音乐以抒情淡雅类为主，同时包含轻快、摇滚等多种元素，她的声音温暖而磁性，有种非凡的力量，可以为人们心灵疗伤，可以在平凡中直指人心，直指你爱的世界，她也是当这无愧的\"亚洲情歌天后\"，对她而言，她是在用她的心和内涵去唱歌，能够用音乐真正跟所有的歌迷交流，分享才是身为一个歌手最大的幸福，就像她歌里面表达的那样，只有了解自己，热爱生活，珍爱身边的每一个人，才能发现使人生变得美丽的神奇秘诀！让我们一起体会静茹歌声中的超然，感受静茹歌声中的积极和快乐！'),(4,'2012情歌从这里开始，光良保利巡回演唱会','2012-07-14','20004','保利剧院','4006103721','39934257','116434883','280 580 880 1280','他一直在写情歌，动人的，平实的情歌，少有那么激昂的旋律和炽烈的歌词，而是《勇气》里，爱情开始时的胆怯到坚定，他曾说他唱歌的时候脸上是没有表情的，因为感情都渲染在声音里，熟悉的嗓音，静静地唱，不管晴天还是雨天，不管孤单还是相恋，不必怀疑，他的坚持，就是这个飞速变化着的世界里执着的守候，那是永远的邻家男孩，伴我们走过成长如蜕的岁月。在盛夏的光年里，让我们一起聆听光良的声音，穿过青葱岁月，点亮万顷心田'),(5,'北京2012崔健演唱会','2012-12-15','20005','万事达中心','400818333','39931095','116447265','280 480 680 980 1280','中国新音乐的先行者，思想者。中国当代文化为数不多的几位标志性人物之一。他在音乐中所展现的理想主意精神和启蒙主义实践的勇气，力量，使他成为一代青年人的精神代言人。他在音乐中那一脉相承，直达生命本质的力量，依然扣人心弦，直逼魂魄，并使他作为新音乐的一面旗帜，永远飘荡在时代的前端。1986年，他在工人体育馆的舞台上唱出那首中国摇滚乐的开山之作《一无所有》之后，崔健一直坚持以现场演唱这种最直接，最真实，最具有震撼力的方式传播摇滚乐和新文化。崔健和他的乐队成员足迹遍及大江南北直至世界各地，演出场次达千余场之多。他的个人演唱会已经成为中国演出市场上常演不衰的经典保留节目。与此同时，崔健创造了大量超越以往歌'),(6,'2012杨坤1/32北京演唱会','2012-12-30','20006','首都体育馆','400818333','39945255','116333902','280 380 480 1000 1280','杨坤在音乐创作的道路上一直在不断的探索，并树立了属于自己的创作风格。他的嗓音磁性十足、极富特点，小豆沙包般略带沙哑的质感声音总在恰到之处划上几个破音，令你徒然后背一凉。而他那近乎于饶舌的咬字，控制自如的质感高音，随心所欲的假声运用和那时常出现在乐句结尾处、极具标志性的沧桑的虚声处理把杨坤的声音装点得非常性感。'),(7,'倾听我们的年代——留欢2012','2013-01-01','20007','万事达中心','400818333','39931095','116447265','380 580 1080 1580 2580 3800','音乐教父、实力唱匠、好声音导师刘欢将于2013年1月1日在万事达中心（原五棵松体育馆）举办《倾听我们的年代--留欢2012》刘欢大型演唱会。10月23日，在京召开了盛大的新闻发布会，演唱会总制作人路建康、台湾金牌导演张文玲、著名歌手刘欢、哈曼国际集团中国专业音响事业部总经理TimothyJSmith、马田灯光高级顾问SimonLeeds、歌手姚贝娜出席了发布会。'),(8,'羽泉2012北京演唱会','2012-12-24','20008','首都体育馆','400818333','39945255','116333902','280 480 680 980 1000 1280','12张音乐专辑、14年的并肩前行，每一首歌曲的真诚传递让羽泉早已不是一个组合的代名词，他已经成为一个时代的标志和榜样。 从2010年羽泉在12月24日举办的第一场圣诞平安夜演唱会，为大家带来了不一样的圣诞体验。而2011年羽泉的“向上人生路”圣诞平安夜演唱会好似为大家上了一堂人生大课，在平凡的人生路上寻找不同的自我。'),(9,'音跃独立日','2013-01-08','20009','小柯剧场','400818333','39990023','116505217','80 100 120','2012年9月4日，“麦田音乐”将正式启动“音跃独立日”。 从9月开始的每周二晚上，在小柯剧场，“麦田音乐”将举办名为“音跃独立日”的系列Live Show，为活跃在豆瓣网的独立唱作人提供精致的演出平台和专业的演出质量。'),(10,'陈奕迅2012feel free ! feel music !北京演唱会','2012-12-01','20010','万事达中心','400818333','39931095','116447265','380 580 780 980 1180 1800','“美汁源”DUO陈奕迅2012演唱会已经随着季节的转变走过了11场，而2012年的我们，亦如同陈奕迅的DUO演唱会主题一样，有开心、兴奋或是感性的一面。就在秋意正浓的时候，连续三场的美汁源陈奕迅《FEEL FREE! FEEL MUSIC!》演唱会在香港热爆全城。演出三晚，场场爆满，门票更被秒杀，众多Eason歌迷大喊一票难求。甚至有报导指出有不法票贩子打着各种旗号，在求票心切的歌迷中招摇撞骗，贩卖假票。网络交易的票价更是炒到无法想象的地步。当晚每个观众都看到热情如火，流连忘返，大呼过瘾。Eason也非常给力，更是二度“ENCORE”，加时演出大奉送！他说这才是《FEEL FREE! FEEL');

/*Table structure for table `delicacies` */

DROP TABLE IF EXISTS `delicacies`;

CREATE TABLE `delicacies` (
  `delicacies_id` int(10) NOT NULL AUTO_INCREMENT,
  `label` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  `avgs` int(5) NOT NULL,
  `image` varchar(10) NOT NULL,
  `calls` varchar(25) NOT NULL,
  `mapx` varchar(50) NOT NULL,
  `mapy` varchar(50) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`delicacies_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `delicacies` */

insert  into `delicacies`(`delicacies_id`,`label`,`address`,`avgs`,`image`,`calls`,`mapx`,`mapy`,`name`) values (1,'官府菜 婚宴酒店','海淀区阜成路2号(近三里河路)',1538,'30001','010-58591188','39923145','116333322','钓鱼台国宾馆'),(2,'情侣约会 朋友聚餐 休闲小憩','北京市东城区东直门内大街新太仓胡同34号名胜酒店内',200,'30002','010-64068806','39938865','116421437','名胜酒店西餐厅'),(3,'情侣约会 朋友聚餐','北京东城区广渠门内大街90-7号',80,'30003','010-63333329','39893127','116421266','壹号爵士'),(4,'朋友聚餐 休闲小憩 随便吃吃','板井路69号世纪金源大饭店B1楼美食区',90,'30004','010-88438044','39953127','116279401','沁园春 毛家菜馆'),(5,'创意菜 徽菜','西城区黄寺大街甲3号',300,'30005','010-64265288','39963273','116393516','海棠居锦徽'),(6,'烤鸭 京菜','崇文区前门大街30号',100,'30006','010-65112418','39899070','116398365','全聚德'),(7,'官府菜 粤菜','东城区南池子大街140号',600,'30007','010-85115556','39909041','116403572','天地一家'),(8,'素食','朝阳区工体北路55号',100,'30008','010-62680848','39934799','116449907','荷塘月色'),(9,'云南菜','西城区前海东沿10号',60,'30009','010-84048986','39938928','116393754','云海肴'),(10,'法式西餐','西城区德内大街东明胡同19号',100,'30010','010-83222103','39943358','116379918','小院西餐');

/*Table structure for table `display` */

DROP TABLE IF EXISTS `display`;

CREATE TABLE `display` (
  `displayid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `image` varchar(10) NOT NULL,
  `host` varchar(100) NOT NULL,
  `descr` varchar(300) NOT NULL,
  `calls` varchar(20) NOT NULL,
  PRIMARY KEY (`displayid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `display` */

insert  into `display`(`displayid`,`name`,`time`,`address`,`image`,`host`,`descr`,`calls`) values (1,'2012北京国际包装博览会','2012-07-03~07-06','中国国际展览中心(新馆)北京市顺义区裕祥路88号','40001','中国包装联合会','飞速发展的中国包装行业已脱离原始资本积累阶段，将越来越倚重科技发展。而中国的包装企业有意识，也有实力去购买国际先进的设备，以缓解人工费用不断升高的压力。因此，博览会在展示包装设备的同时，也将世界先进的包装技术、理念与产品向国内包装企业推介','021-62990137-811'),(2,'2012中国（北京）国际妇女儿童产业博览会','2012-7-19---2012-7-22','北京国家会议中心北京市朝阳区天辰东路7号','40002','中国玩具及婴童用品协会 北京市妇女联合会 国家会议中心','中国（北京）国际妇女儿童产业博览会指导思想以“拓展市场、推广品牌、安全健康、引领时尚”为主题，展示企业关爱妇女儿童事业的良好形象，打造示范、高端的新产品、新技术、新理念的平台及中国妇女儿童信任品牌；展示改革开放给妇女儿童社会生活带来的巨大变化与事业发展的新成就、新成果、新产品；落实中央提出的“保增长、保民生、促发展”的号召和拉动内需的政策，提升妇女儿童消费需求，进一步推动妇女儿童事业的健康发展，为行业国际化、品牌化、专业化的发展提供更加广阔的空间','021-62990137-812'),(3,'2012北京国际珠宝展览会','2012-7-13---2012-7-16','中国国际贸易中心中国北京建国门外大街一号','40003','立新国际展览有限公司','展览会将汇集来自中国及超过18个国家和地区约500家参展商，展出优质珠宝产品。展品包括各类珠宝首饰、钻石、珍珠、黄金、翡翠、有色宝石、白玉、铂金、白银等，还有不同类别的包装原材料、机械设备、鉴别及测量工具等','021-62990137-811'),(4,'2012中国创业品牌招商展览','2012-7-28---2012-7-30','中国国际展览中心中国北京朝阳区北三环东路6号','40004','中国商业文化研究会','坚持以诚信为本、客户价值最大化，打造一流的代理招商、创业投资对接展会。传播创业投资先进理念 协同招商品牌健康发展','021-62990137-805/811');

/*Table structure for table `hotedetail` */

DROP TABLE IF EXISTS `hotedetail`;

CREATE TABLE `hotedetail` (
  `pk_id` int(10) NOT NULL AUTO_INCREMENT,
  `fk_id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `image` varchar(10) NOT NULL,
  `oldprice` int(10) NOT NULL,
  `newprice` int(10) NOT NULL,
  PRIMARY KEY (`pk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

/*Data for the table `hotedetail` */

insert  into `hotedetail`(`pk_id`,`fk_id`,`name`,`image`,`oldprice`,`newprice`) values (1,1,'鱼翅','11',100,80),(2,1,'头盘','12',60,55),(3,1,'大豆苗塌豆腐','13',20,10),(4,2,'甜菜沙拉','21',30,15),(5,2,'罐焖鹿肉','22',150,100),(6,2,'德式香肠','23',80,60),(7,3,'拿铁','31',20,18),(8,3,'草莓松饼','32',15,12),(9,3,'金枪鱼三明治','33',15,12),(10,4,'红烧肉','41',25,15),(11,4,'茶香鸡','42',30,25),(12,4,'绿茶饼','43',30,25),(13,5,'宫廷蚕豆','51',20,15),(14,5,'黑椒小炒肉','52',30,25),(15,5,'两片馒头','53',30,25),(16,5,'私家烤菜','54',40,30),(17,6,'菠萝咕噜肉','61',30,25),(18,6,'火燎鸭心','62',40,30),(19,6,'红豆糕','63',25,20),(20,6,'芥末鸭掌','64',30,25),(21,7,'辽参养生银菊汤','71',100,80),(22,7,'蘑菇炖小鸡','72',40,30),(23,7,'养颜极品血燕','73',120,100),(24,7,'宅门扣肉','74',30,20),(25,8,'白果云耳炒蜜豆','81',20,15),(26,8,'毕加索阳光','82',50,30),(27,8,'慈心如意妙三宝','83',40,20),(28,9,'版纳野果酸汤鱼','91',50,30),(29,9,'菠萝饭','92',20,10),(30,9,'茶香豆腐','93',20,10),(31,9,'傣味烤五花肉','93',30,20),(32,9,'傣味菠萝饭','93',20,15),(33,10,'黑松露少司煎鹅肝牛排','101',100,80),(34,10,'金枪鱼沙拉','102',50,40),(35,10,'咖喱牛肉','103',50,40),(36,10,'提拉米苏蛋糕','104',30,25),(37,10,'小院鹅肝批','105',50,40);

/*Table structure for table `movie` */

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
  `movieid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `type` varchar(15) NOT NULL,
  `time` varchar(25) NOT NULL,
  `player` varchar(50) NOT NULL,
  `image` varchar(10) NOT NULL,
  `descr` varchar(300) NOT NULL,
  `timelong` varchar(10) NOT NULL,
  PRIMARY KEY (`movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `movie` */

insert  into `movie`(`movieid`,`name`,`type`,`time`,`player`,`image`,`descr`,`timelong`) values (1,'灵魂战车2：复仇时刻','动作 / 惊悚 / 剧情 / ','2011年-2月','尼古拉斯·凯奇','10001','强尼·布雷兹以前是个著名的摩托车手，专门做高难度的摩托车表演。后来他父亲生病了，强尼·布雷兹做了一件非常疯狂的事－－他和魔鬼做了交易，把灵魂卖给了魔鬼，以求换得父亲的生命。但是父亲还是死了，而布雷兹的灵魂却归了魔鬼...','95分钟'),(2,'画皮2','悬疑/爱情/奇幻 ','2012年6月28日','赵薇 周迅 陈坤 杨幂','10002','妖狐小唯（周迅 饰）因救人违反妖界规则，被封冻在寒冰地狱中度过了五百年，痛苦不堪。在命运面前，逃离冰窟的小唯只有两个选择：要么被寒冰地狱的冰舌抓回去，要么获得一颗“主动奉献”的人心真正成人。小唯四处寻找目标，直到偶遇逃婚并因一次意外被毁容的靖公主（赵薇 饰）。小唯很快发现，公主有一颗与众不同的心，她把变成人的理想全部寄托在公主身上','135分钟'),(3,'勇敢传说 (2012)','动画','2012年06月19日','凯莉·麦克唐纳','10003','性情急躁、头发乱糟糟的玛瑞达（Merida）尽管身为公主，但却更喜欢当一名弓箭手。这与她妈妈的意愿发生了冲突，于是玛瑞达做出了一个鲁莽的决定，未曾料到给父亲的王国、母亲的生命造成了危险。玛瑞达和无法预料的自然之力、黑暗魔法、古代诅咒抗争着，要让一切重回正轨……','120分钟'),(4,'死神来了5','恐怖 / 惊悚','2011年08月12日','麦尔斯·费舍','10004','一场吊桥倒塌事件，一个男子的预感救了一群参加公司组织的野外拓展活动的同事，令他们遭遇了悬索桥坍塌的意外灾难侥幸逃生。但是这群倒霉蛋们注定无法顺利逃生，在与时间的可怕赛跑中，他们发了疯一样寻求逃脱死神的魔掌。据悉片中还将包括激光眼睛手术的场景，同第四部一样，本片也会采用3D技术直接拍摄，所以肯定十分刺激!','130分钟'),(5,'光晕4：航向黎明','动作','2012年11月07日','Robin August / Iain Belcher / Jenna Berman / Enish','10005','《光环4：航向黎明号》是一部90分钟加长版的真人数字系列电影，讲述这场战争最初的起源，让玩家见证士官长是如何一步一步成长起来的。在第二次地球战役，航向黎明号是皇家海军舰队部署在非洲草原的三艘UNSC护卫舰之一。它对真相先知乘坐的先行者无畏舰发射MAC火炮，试图以火力阻止它开启方舟传送门。这次攻击失败了，并且似乎丝毫无损的无畏舰通过传送门逃向方舟。','90分钟'),(6,'我11','剧情 / 犯罪','2012年05月18日','闫妮 / 乔任梁 / 李小璐 / 于越','10006','王小帅电影《我十一》，又名《十一朵鲜花》，电影延续了王小帅作品一贯的风格，再次涉猎残酷青春题材。讲述了1974-1976年之间发生的一段青春往事：一名11岁的小男孩用自己的眼睛亲历了一桩杀人事件，最后使那个因仇恨而杀人的男人被正法。','100分钟'),(7,'触及巅峰','剧情 / 纪录片','2003年12月12日','Brendan Mackey / 尼古拉斯·阿隆','10007','乔辛普森与西蒙耶茨是一对登山好搭档，他们一起挑战了无数高峰，这一次是秘鲁安第斯山峰。在成功登顶后，下撤的途中，乔发生意外，跌下陡坡，摔断了右腿。西蒙用绳索紧紧拉住他，在暴风雪中下撤。然而在途中，乔再次不幸落入冰洞，两人难以沟通，紧靠一根绳索把彼此连在一起。他们随时都有坠崖身亡的可能，僵硬的两个人也没有足够的食物和水源渡过难关。西蒙手里的刀在绳索上迟迟不决，而他的眼泪已经难以抑制的流了下来。在绳索的另一端，乔又有怎样的期盼，他能绝境逢生么？','80分钟'),(8,'敢死队2','动作','2012年09月04日','史泰龙 / 杰森·斯坦森 / 阿诺德·施瓦辛格 / 布鲁斯·威尔斯','10008','再次经历了一番炮火密集的血雨腥风，巴尼（西尔维斯特·史泰龙 Sylvester Stallone 饰）、圣诞（杰森·斯坦森 Jason Statham饰）、贡纳（杜夫·龙格尔 Dolph Lundgren 饰）、比利（利亚姆·海姆斯沃斯 Liam Hemsworth 饰）、收费公路（兰迪·库卓 Randy Couture 饰）和凯撒（泰瑞·克鲁斯 Terry Crews 饰）这几个敢死队的铁哥们正享受大战之后的难得惬意。可是好景不长，某晚教堂（布鲁斯·威利斯 Bruce Willis 饰）找上门来，迫令他前往阿尔巴尼亚噶扎克山区找一架被击落飞机上的保险箱，并确保箱子不会落入敌人之手，教堂还委派','110分钟'),(9,'白鹿原','历史','2012年09月15日','张丰毅/吴刚/孙红雷/段奕宏/鹿兆鹏/鹿三/白孝文/白灵','10009','白鹿原住着白、鹿两姓人家，白嘉轩（张丰毅 饰）是族长。长工鹿三（刘威 饰）的儿子黑娃（段宏奕 饰）带回一个叫田小娥（张雨绮 饰）的女人，要与其拜堂成亲，被掌管祠堂的白嘉轩拒绝。黑娃和田小娥参加农会并率众怒砸祠堂。革命失败后黑娃逃出白鹿原，田小娥求乡约鹿子霖（吴刚 饰）容饶黑娃，被鹿子霖逼奸，又在其诱使下勾引了白嘉轩的儿子白孝文（成泰燊 饰）。白嘉轩惩戒白孝文并与其断绝关系，白孝文撇下已经有孕在身的田小娥，自买当兵，从此了无音讯。鹿三怒杀田小娥，已成土匪的黑娃回来寻仇大闹白家，鹿三羞愤上梁自尽。白孝文随共产党的军队打回白鹿原并成为县长，把黑娃枪毙在白鹿原一片金黄的麦地里。','100分钟'),(10,'127小时','剧情/惊悚','2010年11月05日','詹姆斯·弗兰科/丽兹·卡潘/凯特·玛拉','10010','2003年5月美国登山爱好者阿伦·拉斯顿在犹他州一座峡谷攀岩时，因 右臂被石头压住被困5天5夜，为了逃生，他强忍剧痛，花了一个多小时的时间，先后将桡骨和尺骨折断，用自己的运动短裤当作临时止血带，然后用小刀从肘部将右前臂硬生生切断。从岩石下脱身后，为了与失血抢时间，他以超人的毅力爬过狭窄和风力强劲的峡谷，缘绳下到60英尺深的谷底，再步行5英里后与营救人员相遇，终于成功生还。','95分钟'),(11,'普罗米修斯','动作/恐怖/剧情/科幻','2012年09月02日','帕特里克·威尔森/查理兹·塞隆/盖·皮尔斯','10011','21世纪末，人类的科技水平已高度发达，克隆人技术和宇宙航行早已实现，不再是梦想。与此同时，许多科学家仍孜孜不倦追索着人类起源的秘密与真相。通过对许多古老文明的考察与对比，科学家伊丽莎白·肖（Noomi Rapace 饰）和查理·赫洛维（Logan Marshall-Green 饰）发现，人类可能是来自一个遥远星系的外星人创造的。在Weyland公司资助下，他们乘坐维克丝（查理兹·塞隆 Charlize Theron 饰）所掌管的宇宙飞船普罗米修斯号前往那颗未知的星球。经过对当地的考察，地球人的设想成功得到印证。可是他们贸然探查“神的秘密”的行为，也将自己引入万劫不复的深渊……','95分钟'),(12,'小杰克的攻击','剧情/喜剧','2005年03月15日','Parker/Bud Luckey/Eli Fucile/杰森·李','10012','小杰克是谁呢？是超人的儿子，而他的保姆凯莉可不知道。就在凯莉拍着胸脯向杰克妈妈保证万事无忧时，奇怪的事一件接一件的发生了。这个婴儿杰克简直是捣蛋无厘头，凯莉被整惨了。最后婴儿杰克“爆炸”了。凯莉被带到安全局接受审查，对她来说忘掉这场噩梦再好不过，很快她就如愿以偿了。','90分钟'),(13,'月神','短片/动画','2012年06月','Enrico Casarosa','10013','《月亮》的主角是一个小男孩，一天晚上他的爸爸和爷爷乘着木船把他带到了远离岸边的大海上，一个巨大的惊喜等待着这个男孩，他终于发现了他们家族神秘工作的真相！不过接下来一个困惑摆在他面前，他究竟该循规蹈矩的按照老传统来继续这项工作呢？还是以自己的方式来完成它？','40分钟'),(14,'大都会','剧情','2012年06月20日','罗伯特·帕丁森/萨拉·加顿/朱丽叶·比诺什','10014','影片改编自唐·德里罗2003出版的小说，讲述了一个28岁的亿万富翁坐着豪华轿车穿过曼哈顿的繁华市区前去做头发，途中遇到了很多人和事。罗伯特·帕丁森将在片中饰演这位财产过亿的青年富翁，由于股市异常，他的全部财产在一天之内化为泡影。','100分钟'),(15,'亚伯拉罕·林肯：吸血鬼猎人','恐怖/惊悚','2012年06月22日','本杰明·沃克/玛丽·伊丽莎白·文斯蒂德/多米尼克·库珀','10015','这部新作的主人公是大名鼎鼎的美国前总统亚伯拉罕·林肯，不过，这位“林肯”将打破以往影视作品中一贯的温文尔雅的政治家形象，而将化身为嫉恶如仇的吸血鬼猎人，影片的片名就叫做《亚伯拉罕·林肯：吸血鬼猎人》（Abraham Lincoln: Vampire Hunter）。','120分钟'),(16,'叛谍追击','动作/惊悚','2012年10月12日','艾伦·艾克哈特 / 欧嘉·柯瑞兰寇 / 丽亚娜·莱伯拉托','10016','影片《流亡者》讲述的是，艾克哈特扮演的前CIA特工，带着和自己渐渐疏远的15岁女儿，来到比利时的一家跨国公司担任安全顾问一职。但是不久他发现公司不存在了，自己的同事也消失了，手下助理其实也是一个特工，并且将要了自己的命。','120分钟'),(17,'派对恐龙 ','剧情/动画','2012年09月14日','Wallace Shawn / Tony Cox / Donald Fullilove / Emil','10017','《派对恐龙》的主角是《玩具总动员》中喜欢一惊一乍但心地善良的绿色塑料玩具恐龙Rex。在《玩具总动员3》的结尾，他和他的玩具朋友们都来到了新主人邦妮（Bonnie）的身边，来到了新环境的Rex认识了一群浴缸玩具，想着要在新朋友面前重塑自己形象的他决定开一场浴缸派对……','90分钟'),(18,'利益风暴','剧情 / 惊悚 / 悬疑','2011年10月21日','凯文·史派西 / 保罗·贝坦尼 ','10018','影片由J.C. Chandor自编自导，讲述2008年经济崩盘的24小时内，在一家投资银行员工身上所发生的故事。贝克饰演一个强硬的精力充沛的证券经纪人，不择一切手段为其客户谋取利益。值得一提的是，扮演贝克客户的是凯文·史派西、史坦利·图齐、扎克瑞·昆图等大牌明星。贝坦尼则饰演一位处于商界食物链顶端的大亨，对于造成金融危机的加剧，无所畏惧也不知羞耻。','100分钟');

/*Table structure for table `movie_will` */

DROP TABLE IF EXISTS `movie_will`;

CREATE TABLE `movie_will` (
  `movieid` int(10) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `player` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `image` varchar(10) NOT NULL,
  `descr` varchar(300) NOT NULL,
  `timelong` varchar(20) NOT NULL,
  PRIMARY KEY (`movieid`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `movie_will` */

insert  into `movie_will`(`movieid`,`type`,`name`,`player`,`time`,`image`,`descr`,`timelong`) values (1,'动作/剧情','饥饿游戏','詹妮弗·劳伦斯','2012年-6月14日','80001','第七十四届饥饿游戏即将开始。在荒蛮的野外环境中，每个人都想置你于死地，你能靠自己的力量生存下来吗？24人参加竞赛。只有一人能够存活。抽签日那天，凯特尼斯的人生彻底改变了。','135分钟'),(2,'喜剧/动画','马达加斯加3','本·斯蒂勒','2012年06月08日(中国)','80002','本片将跟随动物们来到欧洲作为他们环球旅行的一站。此前该系列的另一位导演汤姆·麦克格雷斯曾表示希望片中的角色们能够回到他们的老窝中央公园动物园，不过就此看来这样的事情还不会发生。','120分钟'),(3,'剧情/奇幻','魔镜魔镜 (2012)','朱莉娅·罗伯茨','2012年06月01日(中国)','80003','讲述了白雪公主的后妈杀死了国王，祸害整个王国，白雪公主在七个矮人的帮助下夺回王权的故事','120分钟'),(4,'剧情/运动','跑出一片天','田亮/胡静','2012年06月01日','80004','他不被认可，受尽嘲笑，为了“不输在起跑线上”，在一条洒满汗水的跑道上追求奔跑的梦想，最终能否觅到自己的未来？ ','90分钟'),(5,'剧情 / 冒险','少年派的奇幻漂流','苏拉杰·夏尔马','2012年11月22日','80005','来自印度的动物园园长一家和动物一起乘坐货轮前往加拿大，不料途中货轮失事，少年帕特尔与一只斑马，一只鬣狗，还有一只孟加拉虎先后爬上救生艇，于是，他开始了在海上漂泊227天的历程。由于海关官员的失误，这只孟加拉虎注册了一个正儿八经的绅士的名字：理查德·帕克。在救生艇上的最初三天，鬣狗咬死了猩猩，活吃了斑马，理查德·帕克咬死了鬣狗。接着，16岁的少年帕特尔海上生存的故事，就是如何对付理查德·帕克的故事...','90分钟'),(6,'战争','一九四二','陈道明/张国立/葛优/徐帆','2012年11月29日','80006','一九四二年，因为一场旱灾，我的故乡河南，发生了吃的问题。与此同时，世界上还发生着这样一些事：斯大林格勒战役、甘地绝食、宋美龄访美和丘吉尔感冒。老东家叫范殿元。大灾之年，战争逼近，他赶着马车，马车上拉着粮食，粮食上坐着他一家人，也加入往陕西逃荒的人流。三个月后，到了潼关，车没了，马没了，车上的人也没了。这时老东家特别纠结，他带一家人出来逃荒是为了让人活，为什么到了陕西，人全没了？于是他决定不逃荒了，开始逆着逃荒的人流往回走。人流中喊：“大哥，怎么往回走哇？往回走就是个死。”老东家：“没想活着，就想死得离家近些。” 转过山坡，碰到一个同样失去亲人的小姑娘，正爬在死去的爹的身上哭。老东家上去劝小姑娘','120分钟'),(7,'动作 / 犯罪','寒战','梁家辉 / 郭富城 / 李治廷 / 彭于晏','2012年11月08日','80007','午夜的警队，报案中心接到匿名电话，一辆前线冲锋车被胁持。车内五位警员及武器装备成为贼人谈判筹码。事件惊动警队，不知是巧合还是意外，冲锋车内其中被劫持的警员，竟为 现任行动副处长李文彬独子（彭于晏 饰）。 适逢警队一哥外访未返，下任处长选举的两大热门：鹰派人物李文彬（梁家辉 饰）﹞与年轻的警长刘杰辉（郭富城 饰）都开始大施拳脚。李立即指挥营救，并将此次行动代号为“寒战”。可贼人竟对警队内部一切了如指掌、洞悉先机，警队精英尽出，行动依然无功而返，处处受制，众同袍均开始 怀疑他的决策，推举刘杰辉接手整个行动，危急时刻，二虎相争，刘杰辉毫不示弱，不同与李的激进手法，他选择主动与贼人沟通，并答应交予贼人','120分钟'),(8,'动画','无敌破坏王','简·林奇 / 约翰·C·赖利 / 萨拉·丝沃曼','2012年11月06日','80008','影片围绕街机游戏《快手阿修》中的大块头反派“无敌破坏王”拉尔夫（约翰·C·赖利 John C. Reilly 配音）展开，30年来身高2.7米、体重291公斤的他不仅一次次被人类操作的英雄快手阿修（杰克·麦克布瑞尔 Jack McBrayer 配音）击败，而且从未获得过玩家哪怕一丝好感。厌倦了这一切的拉尔夫决定洗心革面，憧憬着自己也做一回惩恶扬善的英雄。于是他偷偷离开自己的游戏，穿越到了其他电子游戏中，一场反派逆袭翻身当英雄的难忘之旅就此展开。','110分钟'),(9,'冒险/动画','守护者联盟','休·杰克曼 / 艾拉·菲舍尔 / 克里斯·派恩','2012年11月06日','80009','影片讲述的是一个叫做“Pitch”的坏蛋一心一意要在各地的孩子心中引发恐惧从而接管世界，为了阻止他的邪恶计划，圣诞老人（Santa）、牙仙（Tooth Fairy）、复活节兔（Easter Bunny）、沙人（Sandman）、雪人（Jack Frost）以及一群超级英雄破天荒地首次团结在一起共同应敌。','150分钟'),(10,'动作','太极2：英雄崛起','梁家辉 / Angelababy / 彭于晏 / 冯绍峰','2012年11月01日','80010','才挡下“特洛伊”，陈家沟面临的是一触即发的内战。杨露禅（袁晓超 饰）和陈玉娘（杨颖 饰）大喜之日，失踪多年的陈家长子栽秧（冯绍峰 饰），突然带着媳妇允儿（谢欣颖 饰）现身，并以莫测高深的武功震慑众人。未久，高挂在陈家祠堂里的铜钟“大法陀”突然在深夜落地自转、巨响不歇。村 民骚动，他们说“铜钟夜响”是灭族前兆，长老则认为收外姓入门，触犯了祖先立下的禁忌“铜钟谶”。任凭玉娘如何辩护，改变不了家族成员驱逐杨露禅的决心。深谋远虑的掌门人陈长兴亲手拆穿了儿子栽秧的诡计：他用花样百出的科学手法伪装成武功高手，和允儿连手制造骚乱、混淆视听，目的在挑拨离间家族内部和谐，与方子敬（彭于晏 饰）里应外合，陈家沟不','100分钟'),(11,'动作','谍影重重4','杰瑞米·雷纳 / 蕾切尔·薇兹 / 爱德华·诺顿','2012年10月25日','80011','自环球影业宣布《谍影重重4》的摄制计划起，马特·戴蒙(Matt Damon)与保罗·格林格拉斯(Paul Greengrass)是否再度加盟就成为了一直以来悬而未决的话题。最近本片的编剧兼导演托尼·吉尔罗伊(Tony Gilroy)称戴蒙将不再参演本片，同样随之消失的还有杰森·伯恩这个角色。吉尔罗伊表示前三集的故事是本集故事的导火索，他希望在这部作品中描述一个更大的阴谋，并且将为杰森·伯恩未来的故事埋下伏笔。','110分钟'),(12,'恐怖/惊悚','幻影追凶','米拉·乔沃维奇 / 朱利安·麦洪','2012年11月13日','80012','女主角特工安娜（米拉.乔沃维奇 饰）在一场与连环杀手缠斗中头部受到重创，等到从医院苏醒过来后，她发现辩认面孔的功能已经丧失，包括镜中的自己，所谓的“镜子神经细胞”———被诱骗脱离抑制状态。当人观察自己或他人在镜中的动作时，这种细胞就活跃起来。幸存下来的安娜开始过上了变脸生活。她学会了在极短时间内变脸，如此一来便轻松地摆脱了杀手们的视线。','130分钟'),(13,'爱情','天生爱情狂','张智霖 / 刘心悠 / 廖羽翘','2012年11月09日','80013','富家子张泰林（张智霖 饰）在偶然之下结识了俏护士邝美宝（刘心悠 饰），两人堕入爱河，但其后泰林却逐渐发现美宝的另一面：多疑、善妒、控制欲强兼有轻微的暴力倾向，因此非但24小时监视着泰林的一举一动，更以掌握他电脑、微博、facebook与手机号码等方式闯入他的隐私世界。结果，在难 以摆脱这个“天生爱情狂”的监控下，泰林遂偷偷寻找美宝这些疯狂行径背后的原因……','90分钟'),(14,'剧情','给野兽献花','房祖名 / 安以轩 / 李欣汝 / 曾志伟 / 林雪','2012年11月11日','80014','新进巡捕房警员刘美力（房祖名 饰）是个英俊秀气的男孩，眉宇之间总是有着一股难以言喻的忧郁，且有一个叫“美丽”的外号。他从小在风韵的母亲及三个漂亮姐姐的呵护下长大。为了证明自己，不顾家人的反对报考新式警校。毕业分发警局时仍然躲不过女系家人的保护：姐夫梁警长（骆达华 饰）分配美力去巡街，可没想到美力意外地混进黑帮当了卧底。以狠劲出名的黑社会头目光辉哥（陈保元 饰），发觉自己有点性取向错位，于是偷偷求助心理医生，同时发现了刚加入组织的美力居然是卧底警察。出于对美力的钟爱，并想借此洗白自己，光辉哥使出了“反卧底”的招数。','90分钟'),(15,'悬疑','目击者','高捷 / 淳于珊珊 / 魏君子 / 胡小庭 / 贾孝国','2012年04月','80015','影片讲述了两个中年男子因为一起交通意外而纠缠争斗，作为目击者的老宋和肇事者挣扎于救与不救，是否报警等问题之中，原本善良的老宋却因为生活上的种种压力和威胁而走向了人生的另一条岔路。两个男人在善与恶之间徘徊，甚至不惜以命相搏。然后，最终两人发现看似注定的命运其实处处由他人任意操纵。','100分钟'),(16,'剧情','纳德和西敏：一次别离','蕾拉·哈塔米 / 佩曼·莫阿迪 / 沙哈布·侯赛尼','2012年11月13日','80016','西敏想离开伊朗,她要带着自己的丈夫纳德和女儿特梅一起离开这个国家。为此,她几乎已经做好了所有的准备。但是纳德却有自己的打算,他并不是太愿意离开伊朗,他担心自己走了之后,他那患有老年痴呆症的父亲得不到照顾。出于这个考虑,纳德决定留下来。由于纳德的决定让西敏很不爽,她很快就把纳德起诉到法院。她要同自己的丈夫离婚。但是法院驳回了西敏的“无理请求”。离婚不成的纳德离开了家,搬到了自己的父母家。而他们的女儿特梅却决定要和自己的父亲生活在一起,并且希望妈妈能很快就回来和自己同住。纳德很快就发现自己面临的没有妻子的困境——因为自己也要工作,所以他没有时间照顾母亲,而且分身乏术。无奈之下,他只有雇佣了一个叫做','120分钟'),(17,'历史 / 古装','王的盛宴','刘烨 / 吴彦祖 / 张震 / 闫妮 / 秦岚 / 沙溢','2012年11月29日','80017','两千年前的中国，秦王暴政，诸侯起义。血雨腥风的战场之外，散落着建立在密林深处的城邦。被战乱和饥饿折磨得双目黯淡的游民，被梦想和野心灼烧得两腮凹陷的思想家、各种谋臣志士，怀着同一个梦想，穿梭来往于这片伤痕累累的土地。注定要改变这个时代的英雄们，就在这个时候登上了历史舞台——。项羽和刘邦，两个反对秦暴政的起义领袖，带领各自的势力，为自由与安乐一路厮杀，同时也在向那座象征着无上权力与无限财富的王朝核心——秦王宫步步逼近。历史的过程总是曲折而模糊的，结果却只有一个：刚烈而冲动的霸王项羽在“鸿门宴”上错失了杀掉刘邦的机会，只能将一腔热血洒向乌江，与自己深爱的女人虞姬含泪诀别。刘邦和他的吕后，他的谋臣韩信','120分钟');

/*Table structure for table `music` */

DROP TABLE IF EXISTS `music`;

CREATE TABLE `music` (
  `musicid` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `address` varchar(150) NOT NULL,
  `image` varchar(10) NOT NULL,
  `descr` varchar(300) NOT NULL,
  `calls` varchar(20) NOT NULL,
  `mapx` varchar(20) NOT NULL,
  `mapy` varchar(20) NOT NULL,
  `price` varchar(25) NOT NULL,
  PRIMARY KEY (`musicid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `music` */

insert  into `music`(`musicid`,`name`,`time`,`address`,`image`,`descr`,`calls`,`mapx`,`mapy`,`price`) values (1,'千与千寻－久石让·宫崎骏动漫视听大型交响音乐会','2012.06.02-2012.08.11','北京音乐厅','50001','《天空之城》中的爱尔兰民谣；天真、充满童趣的《龙猫》音乐；《小魔女宅急便》中糅合吹管乐与美国乡村音乐的民谣风格；极具日本传统音乐的《幽灵公主》；音乐色彩斑斓又不失大和民族的特色的《千与千寻》……经过交响乐团的演绎，弥散着时代的空灵与神秘。精彩的电影画面让你重温一个个曲折的故事，震撼心灵的优美音乐把你的思绪带入一个浪漫且充满梦幻色彩的童话世界。','4006103721','39906116','116382591','100  180 280 380 580 699'),(2,'中国爱乐乐团2011-2012音乐季','2011.03.17-2012.06.30','中山音乐堂','50002','中国爱乐乐团在中山音乐堂由指挥家菲利普·昂特勒蒙、钢琴家李坚联袂，将为音乐听众献上一台精彩的勃拉姆斯专场音乐会，演奏了勃拉姆斯的学院节日序曲、第二钢琴协奏曲和第二交响曲。这是春节前乐季计划里的最后一场音乐。','4006103721','39913265','116390762','50 80 180 380 680'),(3,'东方世纪行 》——世界风情音乐会','常年','青蓝剧场','50003','东方民乐团是由原中国东方歌舞团与原中国歌舞团的民乐队组建而成，具有五十多年的光辉历程，足迹遍及五大洲八十多个国家，接待过七十多位国家元首，能够演奏和演唱世界各地不同地区、不同风格的乐曲和歌曲。由于其特殊的历史背景和所演奏乐器与演唱形式的不可重复性使乐团形成了自己独特的艺术风格！乐团的任务是向国内的观众介绍世界各地、各民族风情的声器乐作品；向国外的观众介绍中国优秀的传统与现代音乐文化，作为音乐文化的使者发挥窗口、纽带与桥梁的作用！乐团的宗旨是让观众：不出剧院，走遍全球！','4006103721','39933901','116428835','80 120 180 280 380'),(4,'放牛班的春天：法国圣-马可童声合唱团音乐会','2012.10.19-2012.10.20','中山音乐堂','50004','圣马可儿童合唱团(LesPetitsChanteursdeSaint-Marc)由尼古拉斯.博(NicoiasPorte)成立于1986年。合唱团成员都来自同一所学校，年龄届乎于10至15岁。这合唱团在法国里昂已经享誉达20年之久。2003年，该团被电影《放牛班的春天》(LesChoristes)的导演发掘，在影片中担当演出。2004年全世界放映，获得空前成功，全球接近一千万人曾观赏这部电影，而其原声大碟更卖出超过两百万张。圣马可童声合唱团的成功，不仅在他们出色的音乐和受到全世界的欣赏，更在于他们从一所普通学校的合唱团，一跃成为世界知名合唱团。','4006103721','39913265','116390762','50 80 120 180 380 580'),(5,'北京新年民族音乐会','2013-01-01 ','人民大会堂宴会厅','50005','以传统音乐迎接传统节日，传统节日又赋予传统音乐丰富的内涵。喜迎新春，欢庆佳节，中央民族乐团的艺术家们来到人民大会堂宴会厅，与您以乐会友，共聚一堂。','400818333','39911337','116390762','180 280 380'),(6,'李云迪新年音乐会','2012年12月31日','工人体育馆','50006','2012年12月31日，钢琴王子李云迪将在北京工人体育馆上演自己的第一次场馆版跨年音乐会。古典音乐、钢琴、体育馆，几个特别的元素此番齐聚，个中缘由耐人寻味。北京晚报与工体联手，将在这一天全情演示场馆版新年音乐会。','400818333','39939328','116448824','80 180 280 380'),(7,'恋上布达佩斯-匈牙利古典、民间音乐荟萃音乐会','2012年11月28日','中山音乐堂','50007','来自布达佩斯的音乐家小约翰 巴拉兹，菲利克斯 拉杰科，安东尼 伯拉斯杨，米哈伊 德雷施为您演奏匈牙利古典音乐。','400818333','39916766','116401685','30 60 90 120 '),(8,'北美第一爵士钢琴大师戴维·布雷德独奏音乐会','2012年12月05日','北大百周年纪念讲堂','50008','享誉世界的加拿大钢琴演奏大师戴维·布雷德被媒体誉为“爵士钢琴莫扎特”，他被奉为加拿大最有才智的钢琴大师和作曲家之一，是加拿大久负盛名的“朱诺大奖”（又称加拿大“格莱美奖”）的获得者，布雷德涉及多重领域，他的音乐介乎于古典音乐、爵士乐和新音乐之间，他试图把不同音乐流融会在一起。多年来，他的音乐足迹遍及北美、欧洲各国、澳大利亚、日本、中国以及亚洲其它地区。2006年10月，他首次携“戴维·布雷德爵士六重奏”亮相北大，受到师生的热烈欢迎。布雷德先生毕业于多伦多大学，并曾闯入法国巴黎爵士钢琴国际大赛决赛。多年的演出和创作生涯，使得布雷德成为加拿大家喻户晓的音乐家，被媒体和音乐界视为“顶级爵士钢琴演奏大','400818333','39995666','116317495','80 100 120 150');

/*Table structure for table `pekingopera` */

DROP TABLE IF EXISTS `pekingopera`;

CREATE TABLE `pekingopera` (
  `pekingopera_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `time` varchar(15) NOT NULL,
  `image` varchar(15) NOT NULL,
  `calls` varchar(20) NOT NULL,
  `mapx` varchar(20) NOT NULL,
  `mapy` varchar(20) NOT NULL,
  `price` varchar(10) NOT NULL,
  `descr` varchar(300) NOT NULL,
  `address` varchar(150) NOT NULL,
  PRIMARY KEY (`pekingopera_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `pekingopera` */

insert  into `pekingopera`(`pekingopera_id`,`name`,`time`,`image`,`calls`,`mapx`,`mapy`,`price`,`descr`,`address`) values (1,'京剧《佘赛花》','2012.07.27','60001','4006103721','39931804','116356857','50 80 120 ','佘赛花，封号太君。生于后唐清泰年间（934年），佘太君生长在一个爱国名将的家庭里，自幼受其父兄武略的影响，青年时候就成为一名性机敏、善骑射，文武双全的女将。她少年时便与普通的大家闺秀不同，她研习兵法，颇通将略，把戍边御侵、保卫疆域、守护中原民众为己任，协助父兄练兵把关，已具备巾帼英雄的气度...','梅兰芳大剧院'),(2,'京剧《谢瑶环》','2012.08.04','60002','4006103721','39931804','116356857','50 80 120 ','历史剧。是1961年田汉根据碗碗腔《女巡按》改写的，中国京剧院杜近芳首演。此剧为杜近芳代表作，表演清新明快，柔美大方，融青衣、小生与一体，赏心悦目，光彩照人。 此剧亦是中国京剧院（即中国国家剧院）的看家戏...','梅兰芳大剧院'),(3,'京剧《金玉奴》','2012.08.11','60003','4006103721','39931804','116356857','50 80 120 ','《金玉奴》是戏曲传统剧目，亦名《棒打薄情郎》、《鸿鸾禧》，取材于《古今小说》第二十七卷《金玉奴棒打薄情郎》,宋朝时，杭州城金老大就一个女儿，名叫玉奴，生得十分美貌。金老大从小教女儿读书识字，金玉奴到十五岁时已诗赋俱通，调筝弄管，事事伶俐...','梅兰芳大剧院'),(4,'京剧《伍子胥》','2012.07.13','60004','4006103721','39931804','116356857','50 80 120 ','伍子胥是楚国人，姓伍，名员，字子胥。  伍子胥,楚平王听信谗言，计杀了伍子胥的父亲和兄长，伍子胥携楚太子建之子胜逃奔他国，被楚兵一路追杀。 伍子胥二人碾转到了离昭关六十里路的一座小山下，从这里出了昭关，便是大河，径直通吴国的水路了。然而，此关被右司马远越领兵把守，很难过关...','梅兰芳大剧院');

/*Table structure for table `play` */

DROP TABLE IF EXISTS `play`;

CREATE TABLE `play` (
  `play_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `time` varchar(50) NOT NULL,
  `image` varchar(10) NOT NULL,
  `calls` varchar(20) NOT NULL,
  `mapx` varchar(20) NOT NULL,
  `mapy` varchar(20) NOT NULL,
  `price` varchar(25) NOT NULL,
  `descr` varchar(300) NOT NULL,
  `address` varchar(150) NOT NULL,
  PRIMARY KEY (`play_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `play` */

insert  into `play`(`play_id`,`name`,`time`,`image`,`calls`,`mapx`,`mapy`,`price`,`descr`,`address`) values (1,'《喜剧的忧伤》','2012.10.26-2012.11.15','70001','4006103721','39921619','116411476','待定','陈道明、何冰话剧《喜剧的忧伤》是人艺青年导演徐昂根据日本编剧三谷幸喜的作品《笑的大学》改编的作品，全剧讲的是一个剧团编剧和剧本审查官之间发生的喜剧故事。在中国版中，故事的时代背景则改成了上世纪四十年代的中国。人艺对《笑的大学》进行本土化的改编后，定名为《喜剧的忧伤》，在剧中陈道明将饰演一个文化机构的审查官，与何冰饰演的编剧进行一场延续多日的争论。该剧为“对子戏”，也就是双人话剧，难度系数很高。两人将在舞台上上演一场对手戏','首都剧场'),(2,'《活着》','2012.10.26-2012.11.1','70002','4006103721','39905258','116390106','200 320 480 580 680 VIP88','《活着》是\"中国大陆先锋派小说代表人物\"余华的新现实主义力作。作品以一位田间老者对人生的回忆为线索，深刻地展现了世事弄人的时代与悲欢离合的命运。导演孟京辉与作家余华在该作品的思想、艺术方面进行了多次深入探讨，二人思想高度契合并达成共识，欲以一种沉静平和的表达方式诉说人的尊严以及对生命的尊重。本剧由中国国家话剧院著名先锋戏剧导演孟京辉执导，著名实力派演员黄渤、袁泉领衔主演。','国家大剧院戏剧场'),(3,'《雷雨》','2012.06.22-2012.07.01','70003','4006103721','39921619','116411476','180 280 380 480 580 680','1954年，北京人艺极为成功地上演了这部作品，由郑榕、朱琳、于是之、吕恩、苏民、胡宗温等人演绎的剧中人物命运，深深打动感染着观众。多少年来，《雷雨》在北京人艺的舞台上经久不衰，并锻炼了一代代的年轻演员。北京人艺目前上演的以龚丽君、杨立新、王斑为主演的这一版《雷雨》，则集中体现了剧院第三代、第四代演员的优秀表演。','首都剧场'),(4,'《1988我想和这个世界谈谈》','2012.08.17-2012.08.19','70004','4006103721','39934257','116434883','88 188 288 388 588 888VIP','纪念我每一个倒在路上的朋友。','保利剧院'),(5,'《猫》中文版','2012年12月21日-2013年01月06日','70005','400818333','39957798','116478814','80 180 280 380 480','《猫》是音乐剧历史上最成功的剧目，曾一度成为音乐剧的代名词。该剧创作于1981年，是在伦敦上演时间最长、美国戏剧史上持续巡回演出时间最长的音乐剧。该剧创作精良，表演水平精湛，出场演员各有各的绝活，英国音乐剧“第一夫人”佩吉曾在其中扮演“魅力猫”，一曲《Memory（回忆）》打动无数观众。','世纪剧院'),(6,'《风雪夜归人》','2012年12月15日-2012年12月23日','70006','400818333','39911074','116396127','180 300 420 500','一个凄风冷雨的年代，一段哀怨难弃的情缘，一种花自飘零的相思，一场无缘对面的结局。在一个酷寒的风雪之夜，一个人踉踉跄跄地从坍塌的围墙缺口走进苏公馆，手扶着那株枯萎了的海棠树，仿佛在寻找过去的身影……','国家大剧院'),(7,'《安提戈涅》','2012年11月29日-2012年11月30日','70007','400818333','39995666','116317495','20 40 60 80','安提戈涅的哥哥波吕涅刻斯借岳父的兵力回国来和他的哥哥厄忒俄克勒斯争夺王位，结果两弟兄自相残杀而死。克瑞翁以舅父资格继承了王位，他宣布波吕涅刻斯为叛徒，不许人埋葬他的尸首。然而安提戈涅遵守了神律，尽了亲人必尽的义务，用自己的生命作为代价埋葬了她哥哥。','北大百周年纪念讲堂'),(8,'《夏洛特烦恼》','2012年12月18日-2012年12月30日','70008','400818333','39982507','116324813','80 180 280','国际芭蕾舞巨星林佳媚的世纪婚礼正在豪华酒店隆重举行，为昔日初恋祝酒的男主人公看着周围事业成功的老同学，心中泛起酸味，借着七分醉意大闹婚礼现场，甚至惊动了110，而他发泄过后却在马桶上睡着了……梦里他重回高中，报复了羞辱过他的老师、追求到他心爱的女孩、让失望的母亲重展笑颜、甚至成为知名作家、音乐人、网络红人，一连串事件在不可思议中火速发生，他拼命告诉自己这是个梦，却怎么也醒不过来……','海淀剧院'),(9,'《窝头会馆》','2012年12月01日-2012年12月11日','70009','400818333','39927923','116417514','100 180 280','北平解放前一年。一个名叫“窝头会馆”的小四合院里，住着好几户挣扎在社会底层的人家，这些有着形形色色缺点的小人物，有的爱钱如命，有的嘴皮子刻薄，有的小心眼儿，有的木讷窝囊，有的有点不光彩的过去……在黎明到来前的黑暗里，这些小人物与困顿的生活、各种苛捐杂税、恶人的欺诈乃至命运和人心作着各种抗争，而生活的艰辛最终不能泯灭人性的美好，在曙光将现的时候，旧的逝去，新的来临……','首都剧场'),(10,'《高朋满座》','2012年11月28日-2012年12月09日','70010','400818333','39906849','116380303','60 120 200','2012年11月28日至12月9日，繁星戏剧村将再次推出由颜永祺执导的都市臆想三部曲之《高朋满座》，该剧在今年3月完成了经典剧目百场演出，并获得了极大的成功。为庆祝繁星戏剧村成立三周年，《高朋满座》将被改编为更具戏剧效果的小丑剧形式，继续为观众制造感动。剧中，九十九岁的老头和九十八的老太完成了横跨近一个世纪的陪伴，从无话不说到无话可说，从浓烈的爱情火花到平静的相依相守。演员将通过诙谐幽默及生动有趣的表情、肢体和声音处理方式告诉你他们相濡以沫的秘诀。','繁星戏剧村');

/*Table structure for table `recommend` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `recid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `time` varchar(25) NOT NULL,
  `content` varchar(300) NOT NULL,
  `type` int(10) NOT NULL,
  `tid` int(10) NOT NULL,
  PRIMARY KEY (`recid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `recommend` */

insert  into `recommend`(`recid`,`username`,`time`,`content`,`type`,`tid`) values (1,'小冬瓜','2010-11-23','这个不错，推荐',2,1),(2,'我是王子','2012-05-12','求美女一起呀',3,1),(3,'神仙姐姐','2012-01-23','想想都觉得很美，一定要去',1,1),(4,'我不呆','2012-05-11','我真的不呆，你们觉得呢？',4,1),(5,'小新妈妈','2012-04-23','眼前一亮，起居室一定要去！',5,1),(6,'不辣的辣椒','2012-03-25','日子好无聊，找点乐子吧',6,1),(7,'七尺大乳','2012-03-24','不错，喜欢这个',7,1),(8,'军神','2012-02-18','哎，看了后悔呀。。。',8,1),(10,'小泉他爹','2012-04-15','钓鱼岛是我们的，我杨家将要出战小日本！',6,1),(14,'小神','2012-07-02','很不错呀',1,2),(15,'打倒小日本','2012-03-21','中日迟早一战，中国强大',1,1),(16,'我是小新','2012-03-25','不错呀，可以一看',1,3),(17,'老张','2011-12-14','听朋友说不错，有时间去看看',1,4),(18,'哥','2012-05-14','哈哈，笑死我了。。。',1,1),(19,'sdgdfg ','2012-10-30','asdasdasd',1,1),(20,'dff','2012-11-06','shhggjhkjhkhgk',1,1),(21,'dff','2012-11-06','fjhfghjhfgjhfgh',1,1),(22,'dff','2012-11-06','uertrtyityjghfj ghjgf',1,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `name` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  `uid` varchar(100) NOT NULL,
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`name`,`password`,`uid`,`userid`) values ('root','root','root',2),('12345','12345','111fcbde-5560-4076-a5a1-49e0732328c0',4),('12345','12345','49533c5e-83a8-4418-b4ef-06b30df97c71',5),('12345','12345','e89ab60e-2900-4977-92c5-fe4139d58aa2',6),('12345','12345','0a040169-2547-4ea3-a4d8-b42391f8137d',7),('12345','12345','35da4371-2ddd-4c7a-bba3-0f63005f6614',8),('12345','12345','639179dc-ccba-4619-a0aa-dd44c572ad0b',9),('12345','12345','ea2511c3-6945-49ca-a808-cd8bfa7d8518',10),('123','123','ff201bf6-25ae-499a-8fa5-44e6f979a2d1',11),('123','123','98622e7c-2bec-446f-8036-ec8036a8867b',12),('123','123','56b942b3-2929-4d1c-a5e3-3c93debe55c4',13),('123','123','7c6ce64e-ad68-44c9-866f-68ccf29ba683',14),('123','123','2f41f1dc-24f1-427c-a356-665834e72a5c',15),('123','123','6a0bc8a2-8007-4e37-ada8-e88c72c4a81f',16),('123','123','7958aa61-e464-4c0c-8a36-f174496a5205',17),('123','123','4ef8d1c0-47c0-4069-83c1-db938feac327',18),('123','123','85dd0f9f-b9a8-474b-b35d-5bf59e63ba28',19),('1234','1234','683c039a-3f6e-49ca-a27a-21c20442f0ce',20),('1111','1111','2ae5ed70-5116-4d4c-bc1f-adf04f486ca2',21),('123','123','9ff0969c-66d3-4ad7-b4d3-fc47d7f194b2',22),('123123','123123','3ba53bd0-08f1-49ce-97bd-317075e11b9e',23),('wyk','123456','3348412c-d386-4ef5-a5b3-0dedac8620fd',24),('wyk','123456','31d9771b-78ef-49f6-af4e-21f99cf0ae53',25),('wyk','123456','d506d613-bba3-4d10-a3d3-5e79db9dbeb7',26),('www ','123456','a2aeba89-37e0-4e8a-9590-8493088bd02d',27),('aaa','123456','71ad76b2-7fde-43d8-b308-fb90860c2982',28),('abc','12345','8c4ea119-5ce1-4c93-ae65-6026c93ad7fb',29),('xxxx','111111111','d39a1f7e-0f32-4370-b9e6-f501693fb699',30),('123','444444444','118977c6-f43f-4fcd-ae21-7f3d6c52f1fd',31),('fhdfhfg','1234234','42ab75ab-2b31-4df3-989a-807d59032a7c',32),('eeee','132312','d3dfa4e5-f5be-409b-a1f3-c73d2bf49704',33),('ddd','123','d5cdf732-3a1b-4855-afc2-80d75b55c678',34),('aaaa','122345','7bb80ea1-0330-4657-9108-91d73336bc52',35),('hhh','sdasd','030e11ee-a645-4576-a7fd-61454ee3235f',36),('hhh','sdasd','f6b7b835-73c9-437b-9a0d-28d6a90b75a7',37),('sdaf','23123','e55f66d6-43fe-414f-8523-c45b1e28defe',38),('sdaf','23123','26f186c6-8d77-41ab-85f9-9e857ec984bf',39),('xxx','1231231','ded3784b-fdfa-49e3-a98f-7afc7f65a25b',40),('sdgdfg ','234234345','2b637363-c558-4ad7-884f-c46686d80aa0',41),('dff','25434563456','644af367-37ca-4c22-a7a4-17c697ef9fc2',42),('sfsdf','dfgdfgfhfg','d9b166ad-bd48-4eb7-bed5-30b5efec9da2',43),('ghj','rturtuty','9eeae909-9135-449e-9369-8b236baf342d',44),('hjk','456456','96a53545-c4f2-4bd4-b39c-6f097be32bc9',45),('bdqn','12324324','394f6720-70f1-4690-b5a6-e7125e1c269b',46);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

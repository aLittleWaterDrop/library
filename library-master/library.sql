/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50730
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50730
File Encoding         : 65001

Date: 2022-03-23 16:36:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  `isRoot` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'root', '123456', '1');

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `author` varchar(16) DEFAULT NULL,
  `img` varchar(24) DEFAULT NULL,
  `about` varchar(67) DEFAULT NULL,
  `stack` int(24) DEFAULT NULL,
  `get_time` date DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `book_sort` (`sort`),
  CONSTRAINT `book_sort` FOREIGN KEY (`sort`) REFERENCES `sort` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '西游记', '吴承恩', 'images/1.jpg', '古典小说《西游记》共一百回，唐僧、孙悟空、猪八戒、沙僧是主要人物,徒弟三人保唐僧西天取经，历经九九八十一难，终成正果的故事...', '665', '2016-12-27', '1');
INSERT INTO `book` VALUES ('2', '资本论', '马克思', 'images/2.jpg', '《资本论》是马克思毕生研究政治经济学的科学成果的集大成，是一部具有划时代意义的巨著。马克思在这部著作中运用辩证唯物主义和历史唯物...', '666', '2016-12-27', '2');
INSERT INTO `book` VALUES ('3', '中华帝国方志的书写', '[美]戴思哲', 'images/3.jpg', '地方志是当今存世历史资料中数量最丰富、类型最复杂的文献之一。本书是迄今为止首部跨学科探讨方志内容的专著，也是英语世界中有关方志的经典。', '666', '2016-12-27', '1');
INSERT INTO `book` VALUES ('4', '影响地球的100种生物', '[英]克里斯托弗·劳埃', 'images/4.jpg', '作者按照一套多角度的标准选出了100种生物，通过讲述它们的故事来展示出惊心动魄的地球生命史，包含了历史学、生物学、地质学、经济学..', '666', '2016-12-27', '3');
INSERT INTO `book` VALUES ('5', '大岛渚与日本', '[日]四方田犬彦', 'images/5.jpg', '本书对大岛渚的生平身世及重要作品做了深刻、细致的介绍与论述，并很好地结合了“大岛渚与日本”这一相互指涉的主题。', '666', '2016-12-27', '1');
INSERT INTO `book` VALUES ('6', '“后工作”理论', '徐志伟 主编 / 王行', 'images/6.jpg', '本书收录了西方学界关于“后工作”研究的16篇代表性成果。“后工作”理论是针对西方资本主义下异化劳动的弊端，萌生出的对未来文明的一些看法', '666', '2016-12-27', '2');
INSERT INTO `book` VALUES ('7', '深入理解计算机系统', '[US]Randal E.Br', 'images/7.jpg', '本版内容上最大的变化是，从以IA32和x86-64为基础转变为完全以x86-64为基础。大量地重写代码，首次介绍对处理浮点数据的程序。', '666', '2018-12-27', '5');
INSERT INTO `book` VALUES ('8', '计算机组成原理(微课版)', '谭志虎主编', 'images/8.jpg', '本书利用组合逻辑、同步时序逻辑电路设计的相关知识，从逻辑门开始逐步构建运算器、存储器、数据通路和控制器，集成为完整的CPU系统...', '666', '2018-12-27', '5');
INSERT INTO `book` VALUES ('9', '中国哲学简史', '冯友兰', 'images/9.jpg', '20世纪中国一代哲人冯友兰毕生的经典代表作!在20多万字的篇幅里融入了对中国传统思想、文化、智慧等方面的理解，融会了史与思的智慧结晶 ', '666', '2015-12-27', '5');
INSERT INTO `book` VALUES ('10', '查拉图斯特拉如是说', '[德国] 弗里德里希·', 'images/10.jpg', '《查拉图斯特拉如是说》是尼采假借查拉图斯特拉之名说出他自己的哲学思想，也可以说是一本查拉图斯特拉的说教集或者说是查拉图斯特拉的行动录。', '666', '2015-12-27', '2');
INSERT INTO `book` VALUES ('17', '诡秘之主', '爱潜水的乌贼', 'images/17.jpg', '《诡秘之主》是阅文集团白金作家爱潜水的乌贼所著的西方玄幻类小说，融汇了克苏鲁风格、西方魔幻元素、第一次工业革命时代风情和蒸汽朋克情怀。', '666', '2019-12-27', '6');
INSERT INTO `book` VALUES ('20', '清代地方政府', '瞿同祖', 'images/20.jpg', '《清代地方政府》是著名历史学家、社会学家瞿同祖先生的代表作，也是他于学术巅峰时期用英文撰写的一部经典之作。', '666', '2020-03-01', '1');
INSERT INTO `book` VALUES ('21', '美国四百年', '［美］布·斯里尼瓦桑', 'images/21.jpg', '美国的历史不仅是政治性，也是经济性的。美国人以公民身份行使自己的政治权利，以消费者的身份行使经济权利。自由市场代表着美国精神中的...', '666', '2020-03-01', '1');
INSERT INTO `book` VALUES ('22', '法治的细节', '罗翔', 'images/22.jpg', '中国政法大学法学教授罗翔全新的法学随笔，面向大众读者，从热点案件解读、法学理念科普、经典名著讲解等6大板块，普及法律常识与法治观念。', '666', '2022-03-01', '2');
INSERT INTO `book` VALUES ('23', '射雕英雄传', '金庸', 'images/23.jpg', '金庸的代表作，作于一九五七年到一九五九年，在《香港商报》连载。之后被拍成各种语种的电影和电视剧在全球众多国家和地区热播。', '999', '2022-03-01', '6');
INSERT INTO `book` VALUES ('24', '黄金时代', '王小波', 'images/24.jpg', '那一天我二十一岁，在我一生的黄金时代，我有好多奢望。我想爱，想吃，还想在一瞬间变成天上半明半暗的云，后来我才知道...', '999', '2022-03-01', '2');
INSERT INTO `book` VALUES ('25', '中华上下五千年', '吴兆基 / 臧瀚之', 'images/25.jpg', '本部《上下五千年》的编写，不同与传统教科书面面俱到的写法，而是选取了几百个在中国历史上占有重要地位的故事，既包含精彩的人物特写...', '999', '2022-03-01', '1');
INSERT INTO `book` VALUES ('26', '你一定爱读的极简欧洲史', '[澳] 约翰·赫斯特', 'images/26.jpg', '《你一定爱读的极简欧洲史》是一部“最短”的欧洲史。它以极简练的文字，却从不同的角度，把欧洲历史的精要述说透彻！', '999', '2022-03-01', '1');
INSERT INTO `book` VALUES ('27', '野草', '鲁迅', 'images/27.jpg', '本书于于年1927年4月由作者亲自编定，同年7月由上海北新书局初版印行列为作者所编的《乌合丛书》之一。', '999', '2022-03-01', '2');
INSERT INTO `book` VALUES ('28', '王尔德童话', '[英] 王尔德', 'images/28.jpg', '王尔德是19世纪英国最伟大的艺术家之一。在风流才子那颓废唯美、狷狂放浪的表面姿态下，是一颗纯美纯善，永难泯灭的童心。', '999', '2022-03-01', '6');
INSERT INTO `book` VALUES ('29', '明朝那些事儿', '当年明月', 'images/29.jpg', '《明朝那些事儿》讲述1344年到1644年，明朝三百年间的历史。作品以史料为基础，以年代和具体人物为主线，运用小说的笔法，对明朝...', '999', '2022-03-01', '1');
INSERT INTO `book` VALUES ('30', '被讨厌的勇气', ' 岸见一郎 / 古贺史健', 'images/30.jpg', '并不是要去吸引被讨厌的负向能量，而是，如果这是我生命想绽放出最美的光彩，那么，即使有被讨厌的可能，我都要用自己的双手双脚往那里走去。', '999', '2022-03-01', '2');
INSERT INTO `book` VALUES ('31', 'N号房追踪记', '[韩]追踪团火花', 'images/31.jpg', '窥视威胁女性，以伤害女性获利，这些罪恶并不遥远，甚至就在你我身边。我们可以沉默,但也可以绝不罢休。', '999', '2022-03-01', '2');
INSERT INTO `book` VALUES ('32', '麦田里的守望者', 'J·D·塞林格', 'images/32.jpg', '《麦田里的守望者》之所以受到重视，不仅是由于作者创造了一种新颖的艺术风格，通过第一人称以青少年的说话口吻叙述全书，更重要的是...', '999', '2022-03-01', '6');
INSERT INTO `book` VALUES ('33', '如何阅读一本书', '[美] 莫提默·J. 艾德勒', 'images/33.jpg', '不懂阅读的人，初探阅读的人，读这本书可以少走冤枉路。对阅读有所体会的人，读这本书可以有更深的印证和领悟。', '999', '2022-03-01', '5');

-- ----------------------------
-- Table structure for `lend`
-- ----------------------------
DROP TABLE IF EXISTS `lend`;
CREATE TABLE `lend` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lend
-- ----------------------------
INSERT INTO `lend` VALUES ('67', '13', '1', '2022-03-01');

-- ----------------------------
-- Table structure for `sort`
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sort_name` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sort
-- ----------------------------
INSERT INTO `sort` VALUES ('1', '历史');
INSERT INTO `sort` VALUES ('2', '社会');
INSERT INTO `sort` VALUES ('3', '科学');
INSERT INTO `sort` VALUES ('5', '学习');
INSERT INTO `sort` VALUES ('6', '娱乐');
INSERT INTO `sort` VALUES ('11', '艺术');
INSERT INTO `sort` VALUES ('12', '信息');
INSERT INTO `sort` VALUES ('13', '报刊');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(11) DEFAULT NULL,
  `password` varchar(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL COMMENT '0表示该用户已锁定',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('13', 'Test01', '123456', '1');

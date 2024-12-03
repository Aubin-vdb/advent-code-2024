import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day3 {
    public static void main(String[] args) {

        String input = "]@;why()]&where()@select()mul(589,854)${ <-}$how()^#mul(517,928)^(%@#who()@'mul(82,659):don't()mul(670,226)when(626,911)from()&%{%where())-mul(244,869)<]mul(582,125)<mul(219,47):'!mul(95,365)select(){how()how()select()mul(273,775)[$!],?)@mul(955,698)what()where()/;mul(79,369)&?*$do()from()@mul(994,313)what()mul(603,3)'~@]'@@mul(729,217)#-/mul(561,454)!mul(588,577)^%'{mul(705,583){*;+;mul(418,129)~@:^mul(449,366)@what()},-)):^*mul(842,848)%what()where():what()))<from()/mul(775,104);&mul(425,243)%//{what()who()?{mul(842,148)how()<!who()@mul(197,181)@(~$ from()do()how()#-[&)who()$mul(254,640) what(){why(807,52)-+~!+who()mul(948,873)mul(127,689)~$*-mul(147,430)~!who()}where()where()mul(476,718)select(86,742)@!?when();from()do()>why()>why())+mul(96,44)mul(179,145):*~^what()~what()who(595,39)+mul(174,903)%?<]&~mul(13,307)how(98,997)}who()select()?^{:mul(858,7)]from()why()how()mul(681,532)from()when()from(){select()>[{(}mul(908,908) $,mul(221,664)!:)~mul(327,84)how()-&~+ ]mul(865,773);*who()%,/%where()+mul(543,871)!(){]from()mul(257,93)(?(]mul(659,259)}~-#)]/what()why()mul(647,723)what()(why()who()who()select()$(where()mul(189,838)who()&mul(231,195):?[+#/ what()mul(892,824)(:mul(467,622)how()mul(245,161)(} ~mul(5,520),mul(116,331)what()<what()%]from(613,447)>mul(227,866)$#mul(4,224)#;{~mul(543,410):#[/what(272,644)what()>:+why()mul(869,342)} mul(990,443)(mul(575,968)>who()'~;where()-^mul(496,181){why()/}do()mul(334,968)mul(390,266)what(),don't()@<-who(302,636)mul(780,340)-?who()]mul(256,735)who()mul(230,265)- why(),[/select()>-mul(822,763)who()how()<*-@mul(914,719)where()from(),mul(515,606)when()#~)how()mul(412,4)where())>@[mul(264,473)<why()}how()what()%}+!+mul(541,503)?(/what();where(){ from()+mul(381,126)%select(),$'{^);mul(511,611)^mul(825,203)mul(117,405)mul(375,348)<:*(}!*?@mul(529,944)+who()(&+!mul(297,217);#who()}from(94,251)@do()!:mul(410,847):!;mul(585-^)who()mul(489,753),@&![mul(54,446)^<!@mul>when()#mul(164,221)when()<<how() (++when()mul(55,438)why()@[+~^!*{mul(784,845)why()(when()~mul(747,880)&>when()why()from()'#mul(122,483)mul(866,284))^why()$!mul(620,149)mul(620,850)select(){#@[why()+#!mul(999,114)!mul(151,527)who();>+:)+what()where()(mul(34,202):*,!where()]#!mul(668,743);/<{when()}when()%mul(768,640)*)<{mul(920,573)??:mul(438,188)^&mul(126,506)}mul<mul(240,639)?when()<}';!mul(846,177)when()%who()why()&!&$ mul(267,452)/&;mul(940,265)who()+who()[~mul(966,189)who()what()!!+select()]#mul(777,758):;from()select()?})]mul(442,116)!select()/?*where()mul(667,853)select()where()~-/what()*/mul(488,725)]<]?from()mul(628,497)/(select()when()^(;don't()why()&/#*(mul(849,651)select()select()when()from()':mul(862:~'mul(502,27)?when() mul(444,563)where()!!mul(266,682)}~select()<how()#-;mul(394-)from()where() ~mul(787,146)where()when()mul(83,219)'<(!]#$)mul(731,303)what()how()$*why()?#mul(286,142)<,,<%}{;~'mul(203,494)}{from()>&mul(733,119)\n" +
                "*#!*& ,[mul(23,230):& who(794,799)]mul(501,249)),^(&%:;%mul(383,5~when()how()!where()mul(284,350)select()]#+*do()select()select()&(~!who()mul(450,794)where()}<how(638,85))select()[when()mul(987,169)!:who()who()]where()~mul(772,547){&{+'<)/mul(672!%>$<~do()-'when()$,who()where()(&[mul(216,443);mul(973,192)who(){)+?:$from()mul(711,798)mul(103,581)-*/',mul(634,298):~from()*'what()mul(908,815)who()@!what(),&[when()#from(566,230)don't()[)@:('when(135,517)@[~mul(168,993)&{mul(766,123)mul(617,944)what()how(612,771)>mul(36,224#{):*#mul(188,512)mul(761,172)-]<#who()}{;mul(546,680)do()from())-mul(45,151)from()~,<%$where()(why(994,767)~mul(61,14)@?mul(52]why()!{}mul(993,666)*when()from():mul(383,122)<>where()$*^,where()%!do()where()when()&who()>),&mul(752,434),$*mul(4,982)how()*<+?why()[<mul(733,30)mul(963,772)<mul(173,216)%-?when(912,63)/mul(460,390)}}~do()(%>when()#@-:who()mul(608,612)<?>do()~from()*{{&what()mul(449,733)>}(how()%<why()mul(956,790)-when()$mul(606,186)~;)^;from(186,419)where()mul(239,441)what(419,65)mul(203,723)+$* $<@*~/mul(830,346)/]*]don't()what()mul(961,935)+where()who()#-?when()#who()mul(903,987)mul(94,157){;;}[who()/;'mul(626,310)~'select()),-mul(75,290)~#^$%[:@{mul(713,684),why()where(479,628);why()why()(<'!do()+#?-}{$why()^mul(988,907)#select()mul(13,315):/select()don't()<>(mul(124,264)from()?+,~!mul(349,575)?*why()-:mul(219,424)'where()+{<why()don't()when()mul(584,464)%when()[who(762,56)!mul(848,467)why()]mul(658,723)what()-?',how()!*?mul(581,986)select()%why()%<<}^mul(303,522)/#<%@!why()%/;mul(874,460)where()don't()!@{%>mul(896,353)$~mul(170,156),-~(mul(336,127)~;%mul(952,324)@&what(593,379)[~from()+(mul(663,926)&*who():mul(926,664)mul(730,590)++) /%@+^mul(376>select()}]~{why()mul(816,831)@?~*mul(827,787)}~,{how()]mul(36,953)< ~[&)mul(710(who()when()[-mul(238,172)from()how()}&[(mul(116,962),]mul(32,211)*;mul(52,576);,&%/!why()$mulselect(387,81)^from()?where()]]from()mul(751,197)~ ]}where()*mul(394,798)?mul(470,152)why()>;from():;mul(37,777)@%who()<where()?what(),mul(726,980)!'->$ -)why()how()mul(683,322)]/?:&(from()(<-mul(528,165)-mul(853,835)mul(51,666);]]}@~where()mul(277,561)what()-)who(531,214) (select(464,268)[mul(462,883)when()/#&;*(how()mul(971,528)+{* who()]from()!:mul(987,908)from()'^ +~who()'# mul(309,850)@([:-mul(954,596)}%,where():mul(299,674)~how(369,907)@*from()mul(288,319)%from()/#/-mul(379,967)]when())~>(select(),&+mul(375,757)>!?~[ don't():mul(850,510))[#}how()mul(339,21){[select()@what()#(*mul(850,794)where()}where()mul(732;mul(949,117)<-why()@ mul(164,964)why()where()do()>; what()(why()mul(301,339)-from()+mul(772,733)%<when()<;);:!)mul(317,152)*-+mul(937,936){when()why(),from()mul(675,788)from()select()when()](,mul^?who(822,353){&{mul(3,950)<, (don't()why()#mul(798,259))}how()mul(985,246)-/@*mul(798~)#what()!^!?[mul(602,590)><-*mul(676,652)>-$what()$,:#mul(241,262)mul(779,695)<where()+why()mul(929,886)^@mul[mul(626,215)where()~who()+-?mul(440,991,:mul(63,308)@'#-(#mul(461,769)&mulwhere()^!>who()where()@~^mul(953,533)'?}-mul(574,8){<?^?mul@)*do()?where(){{- -?from()mul(62,320)'who()why(),+$#from()mul(977,809)<}:what()]{]who()mul(186,824)^what()^who(865,32)why()mul(231+*who()-mul(586,251)&from()[<,mul(602,937)?! <&how()-mul(811,526)\n" +
                "where()>}>!/'{mul(120,422)from():[who()'mul(134,206){mul<@;why()who()what(174,369)?)+don't(){%-mul(309,356)how():how()% mul(68,976)%'who(848,62)-select()<<;]?don't()how()who()^:mul(721,500)!%(@[^$]%>don't()/;}~<%<]~from()mul(124,237)when()why()?mul(667,691)(select()why(801,843)from())where()]);mul(934,249))(#[[(!@where()mul(719,833)why()%{,%why()-{@what()mul(143,782)?mul(236,29):when(705,76);%where()who()mul(35,222)}how()</mul(269,419)why();from();~'mul(826,942)!mul(878,726)mul(383,604)%@mul(284,286)]#})/why()]mul(651,863)select()>;[ +^mul(841,155);mul(6%{mul(112,401)-:when()/ !-@'mul(737,347))%+mul(544,414))>&mul(637,69)'*{:'-how(),mul(335,890)~>?select()when()mul(404,466)@^{~?&$(^$mul(272,686)};*%who()mul(17,310)~?+//{who()what()[ mul(828,379)~from():mul(962,479)*-]when(){/~'select():mul(537,147)mul(273,8)]how()when(606,831)-from()mul(113,55)select()]](<!mul(123,557);$+@!mul(845,259)<<mul(107,646)}mul(819,482)*-#}$&(#%select()mul(678,426)'^%-,[ mul(537,931)select()+^(!(select()mul(306,530){]{%mul(392,457)@(,why()from()how()#)?mul(11,465)'+do()(what()when()*)@{$%?mul(994,884)mul(45,257)[&]^,^;how():mul(10,345)$>-mul(335,418))$how()what(),select()]where()mul(208,124)[*:*<*~!mul(857,835)(^+from()select()[mul(324,847)(mul(27,487)/where()?>$$#select()%!mul(998,728)&:;mul(185,675)$how()%>(mul(750,550)?!#^!#do()select()#select()from()why()mul(231,706)why()>[< :where()mul(210,674)?!mul(455,525from()who(225,80)[!mul(69,976)/mul(498,162)!%*mul(930,795)who()from() *mul(467,174)$mul(711,259/>;select()$*from()where()]mul(788,339)*from()'*)}from()mul(714,649)%!>mul(894,470)-$?from()/mul(794,135):))}*mul(165,454):*,;&(mul(527,765)when(430,743)!select()}-'{{?mul(734,592)&+^who()mul(541,139)?(@mul(310,602)who(915,791)#why()mul(372,17)where()&^{<?mul(256,240)?mul(970,2)^mul(98,951)(+?)'from()what()when()who()what()mul~-mul(614,6))%mul$-*/from()mul(6,809)[:$?do()~(from()/;mul(13,152)!)*}where()select(),mul(155;,({]/[mul(763,222)who()what()mul(567,471)?where(590,638)&<{don't(),^-;[ *(mul(492~*?*{}~mul(75,386)~mul(817,213)from()[^ how()'who()$+where()mul(547,786)who()when()-^;)/{from()mul(979,599)when()mul(144,790)who()from()from()select()):mul(69,63)}^mul]<}~>what(802,670)/{/?from()mul(87,377);mul(859,482)mul(682,385)do()mul(760,768)&}&$mul(56,548>-'^select()from(): ]mul(591,699))when()where()<what()who()'{mul(72,140)select() <don't()mul(680,625)^&why():@~do():<>$~{;~-mul(789,792)mul(816,432)>select()!+{?'why()mul(119,972)who()'what()~mul(197,605)&+mul(363,327)where()from())mul(833,826)[from(223,745)?why()when()what()select(528,707)?$don't()mul(208,697)select(),~,};}&-mul(766,143)why()}/mul(184,251)where()'}from(355,411)!mul(32,532)mul(256,569)mul(505,421)^mul(170,571),select()select()]@!how()select()select()mul/<~'[do() /who()]from()((select()^mul(792/why(),< ((how()mul(151,968)when(576,645))how()how(748,886)from()what()where()mul(353~mul(294,14)when()%@(&how()+[who()<mul(717,624)$:mul(813,69)*from()[')why(),{&-mul(621,124)^#select()[?$what()!//mul(410,329)mul(664,707)} mul(936,655),!,why(393,496)mul select()- #)]/!mul(354,173)'%#!/usr/bin/perl!}}/from()~what()mul(314,880&when()from(334,252)'/#~mul(703,259):&$<mul(294,740)(select()~*>&&where()}+mul(107,18)\n" +
                "when()+[[$,/mul(214,168))where()#:~{[?what()mul(247,154)!<-!mul(157,305)+#when():[*,!mul(908,273)who()who(328,847)'~#don't() *why()when()~mul(43,270):mul(846,863)from())*/mul(460,803)<-[-when()@mul(429,235)%}-']~>select();mul(699,447) } why()what()mul(207,60)>% mul(975,236)*>',who()^]where()how()mul(448,703)#mul(210,872)how()!+what(),mul(981,127)what()[why(),how()?{where(982,584)from()<don't()!>@,mul(356,291)(mul(383,710)%()^how()::{what()/mul(33,273)how(),)*why()what()%]when()mul(324,71)where()+-%^what()<mul(302! *where()@[':,/mul(161,74)when() <(mul(821,165)where()where()mul(507,571)(?$when()%:'from()()do(){&where()where();who()mul(840,111)mul(997,729)}'~;]why()>-mul(333,808)mul(567,862),#)#[:[do()+,^~why()>({mul(919,726)what()select(),-%,how()%mul(176+$ {~mul(367,970)where()#mul(979,781)*{-+$^[ where()do():})who()why()[mul(735,790)!}*-)&where()mul(127,446)//]~&who(464,5)!:];mul(637,648)$},why() (~+mul(334,39);;@-*from(919,410)when()mul(234,40)mul(484,981)-select():] </mul(311,64)mul(61,543)(>! +why()@*&$mul(484,129*@select();:%-@${(mul(118,602),{}select(),who()mul(309,820)when(){/(what()$mul(752,138),why()+what();~<]mul(27,797)[{;what()&!?mul(790,119)what()what()where()#<+:^]mul(114,600)#where()+what()&^^when()don't()+@mul(26,835):$who(670,428))mul(128,236)#&?[-mul(963,974)~what(),where()~~mul(511,248)^]mul(727,492)/)#---how()how()mul(137,681)*](mul(112,337)how()why()/from()mul(602,710)mul(649,464)when()when()>< from()where()mul(729,307)/;!what():mul(373,940)($#}(^/select()mul(155,225)^[@'<$mul(578,989)when())when()who()where(728,446)*-,mul(505,564)when(856,695)]mul(609,465)where()$?,*from()who()mul(763,718)~,do()-from()+mul(700,342)from()'};^mul(9,577){#where()  {^how()what()don't()[<where(326,346)&how()mul(371,390)*who()~#]select()mul(740,144)where(){;#why()];)mul(754,619){}what()mul(118,572)when()select()mul(792,892)when()>[^[:~,<mul(648,32)[!?>mul(563,892)mul(945,545#when()}why()<@[ mul(6,257):!@@^:^+^~mul(772,130)<mul(984,882)[:]{'what()when()mul(196,34)who()&#}when()select()mul(403,841)when()-what()what()~[#~mul(198,544){'<where(166,27)/where()/>how()do()!who()+<)]%!why()mul(384,171)select()$why()[select()%why(793,440)when()$how()mul(364,920)how()^select()mul(826,816)[%]@}mul(891,416)^]what()%%({]mul(569,947)how()from()from()#{>mul(796,659),where()]^mul(235,994)${mul(315,694)how()))mul(253,674)$who(),>$~mul(41,530)(*(~?mul(616,99)who()@where():where()&;+why()]mul(658,220)^when()?mul(754,366)from():<~!$mul(898,950)who()@&mul(94,544)!/]who()/!?(mul(751,464)'from() mul(59,58)who()@]~)what()mul(694,790{?what()+ @'&mul(835,235)when()-mul(297,423)>@*mul(20,635)*!mul(889,955)( )from()[mul(586,592),)({mul;mul(275,534)'why()mul(286,601);who()}&'mul(524,526)mul(716,437);when()?*/mul+mul(341,491)/[mul(271??-select(640,365)where()mul(856,857):why()[&&mul(155,676)'])-mul(285,962)%(,/who()&where()why()mul(237,335)from()select(39,590)]&)mul(196,617)/}~when()mul(773,534)&<){!mul(840,240)mul(259,240)how();!?mul(404,805)mul(963,770)-why()from(776,365)^mul(631,33){{&>mul(840,149)!++'#'#;?mul(501select()who()$why()~>$mul(986,499)~]*(select(590,180);?what();do()))mul(518,563)\n" +
                ",&(select()/#@mul(142,176)<+from()select()mul(675,444)*$'select()%what()#]mul(260,681)*(>how()#+*mul(800,885)-where()&?@[*when()from();do()(&from():#mul(626,59)@$%#who()mul(918,45)+[(!! how()mul(636,583)(&)who():!%-%mul(713,392)when()$%mul(445,40)&~%#-'%mulwhat()@>@mul(556,475)why()where()$~(from();mul(111,289))&+who()&select()@mul(603,119),{!;how()],*<'mul(258,922)@ [^(?%mul(923,465)where()from();what()}^select() #mul(269,177)+select():don't()^!&/mul(351,938)]',^/why()mul(198,845)who()from()do()$when()what()-who()%] ,mul(856,405)why()mul(858,985)^*what(); mul(935,994)from()#)'select()#mul(118,794)%(where()select()%>mul(502,362)who())mul(410,257);@(@-,mul(850,203),from()when(297,956)<@%{how()mul(336,134)'+ ]how(950,425)when()}mul(635,646)[)} <why()from()mul(583,302) ,when()[+($>why()~mul(784,93)mul(268,459){)~select()<when()mul(526^:#who()>;;mul(237,251)what();mul(408,339)+from()'why()@%mul(708,708)mul/mul(408,187)-where()-??$~$ ;mul(474,656)what()[:do()<from(), }!who():mul(149,460)why()#/[&$?how()'*mul(73,460)[>~~-!mul(680,402)/select()?((how()how()+mul(554,8)#mul(650,749)mul(78,63)&*why()+[{who()#{-mul(969,124);}>from()mul(111,152)+why()from()mul(979,902)&';/from()[mul(269,698)(-/where()*how()}mul(558,314)@select()mul(767,511)!)@$%?'>when()mul(548,448)>#{where()@(-[*when()mul(865,189)]where())*@mul(298,707)>+))-<*/who()do()]#'}mul(907,948) //when(411,489)what()>,@{+mul(531,197) who()mul(295,590)$$(how()mul(650,275)(from(863,97)}}!^-^,what()mul(677,618)+$mul(751,83)-+from()how()-~mul(200,556)^'}><when()]how()mul(418,125))how())>[when()mul(95,717} ;when()$#(&'^{mul(802,848)/when()<~mul(442;}mul(496,455)^]*$how()?}from()select()mul(914,635);mul(86,655)!++mul(692,303)!how()mul(550,704)#})*#;how()+&mul(696,443)%<%from();how();mul(873,149)mul(293,653)}%#: where();(mul(815,587)'+-where(),>select()<!why()mul(611,569)}from()who()mul(560,134)mul(295,312);what()?::mul(798,705)where()?/from()$@!mul(393,329)('+?where()when()/mul(318,165)-{ ]who()who()what()where()]mul(610,489)>mul(571,536)mul(591,230);@mul(260,248)&:mul(148,24)mul(246,496)[when()why(797,860)?#!mul(227,69)*select()mul(279,848)+##mul(79,786)% ,]mul(916,494))*$;{when()! >don't()from()$ !<*(when();select()mul(207,342)!when()<:*&!select()({mulwhen() where()how())/>when(114,161)!@(do();[$$how(18,592) *#why()where()mul(439,193)}]@%~from()]!}don't()^how()what()who()when()who(968,843)mul(534,530)*mul(75,303)mul(113,965)how()<<[{;mul(815,821)<what()~(,$'mul(839,58)}how()mul(212,598)@@((where()mul(762>from()mul(926,936)#- >+)when()?do()mul(883[;;mul(147,254)*#}/when()mul(750,402)}-&,mul(852,52)~$where()mul(731,737)<~%,;,,^')mul(22,190)@~-%from()<when()mul(805,375)+/<>(  mul(378,829)(&%>#;!)when()mul(740,339)){/what()mul(540,592)mul(964,822)+mul(770,246)+why())mul(863,653)^from()*+?select()@<-'mul(313,656)what()don't(),-+what()@@#$mul(507,90)(:when(731,317)%who()why(),!(mul(485,972)%?mul(729,643)#>(#>+from()mul(145,213)mul(449,499)/@;:(]!]$mul(926,176)<mul(57,501)?from()<;;-?mul(799,636)?mul(218,198)\n" +
                "(mul(827,197)(,!!#[mul(372,115)what(){+-mul(678,930)~!?~mul(167,912)how()?%/}do()select()[/- >+mul(684,228)select(465,755)what()'mul(164,505)mul(577,347)'^from():$::}mul(478,394)%-* mul(890,910)mul(435,174)from()mul(45,739)#'}}?+ mul(608,614)#who())(mul(437,279)mul(135,37)&+(how();^~&?mul(819'] mul(119,163)@where()>from()?<@ ;-mulwhat()what(),$who()^mul(720,224)];[>mul(159,464)mul(212,783)[mul(737,184)',;where()!select() ^{don't()'<)when(531,575)((>'*,mul(693,133)~?what()mul(762,58);'*[!mul(357,260]+&$(select():%how()mul(81,45)}*what();how()mul(832,898)mul(982from()?when()why()[)mul(192,688)mul(173,865)mul(803,918)%mul(672,984)?^what(886,509)+@^*;]mul(527,340))mul(249,872)!select()#)mul(200,814)what()] @ who()don't()~what()#what()mul(314,985)from()~*,%[mul(638,521)select()>#mul(438,516)~~+&)mul(616,938)where(571,82))?/}*from()^~:mul(501,633)$!>how()mul(573,985)@what()mul(644,942)/*'select()%mul(906,350)>*how()<:''mul(782,807)}where()/^~ mul(85,249)@why(306,270)mul(456,289)?-mul(619,539)!do()mul(855,724)!:mul(732,256)mul(170,879)#@-^}mul(909,290)??what()[>mul(372,185)*select(){where()don't()who()##mul(385,998)*?*[+[~mul(372,856)how()&why()from()&<&mul(994,771) why(893,306)/~^who()!!}mul(546,38)from()& why()^}~*@where()mul(422,592)who()from(680,610)~where()*who(779,112)how()mul(504,670);%-}:how()%mul(593,39)/$mul(9,683)!mul(690,886)?how()#$mul(789,984)*!^ $~!mul(810,923))when()who()how(),@what()mul(110,783)>mul(915,154):what()#select()when()when()]mul(527,185)~#>>?%who()what()what()mul(639,775)do()[-&when()how()where()who()>mul(536,148),{from()what()']who()mul(881,967)$;mul(17,490)+}!:>where()^mul(173,498){&>from(470,979)mul(984,973)from();{&;[mul(996,319)from()when(231,33)>&(mul(367,363)mul(656,760){%$&((?-how()mul(659,794)@^where()<,+do()~who()~&]why()^mul(426,888)&}<~;mul(74,172)/how())%:how()];{mul(21,986)>mul(150,723){what()}from()mul(878,969):']when()~ where()mul(462,974)>+mul(885,808)?<[!(mul(488,285))(mul(788,538),{+who()when(829,876)&!mul(854,972){when()mul(437,889)>()/mul(336,730)^($when()@mul(486,936)][how(),$] <?mul(513,377)~:who() !,-+what(326,225)mul(837,332)+select():)]mul(818,528)where()-mul(703,152)~#where():how()mul(793,666)why()[?@(,^when()+mul(807,459)@ +>'}don't()<]~~?)mul(321,307) select()^(mul(954,263)*~select()select(637,420))/??why()why()mul(94,567)~{#:from()-mul(311,510)'^ when();&what():<how()mul(990,389)when() ^)$:*^[mul(432,471)how()}){mul(495,302)why(459,93),'select()why()/^*@#mul(996,631)when(792,547)}:?<mul(48,418));;-,()@+what()mul(392,244)-~mul(669,351) how()!mul(957,745)who()#:}where()^]where()~mul(164,270)%/mul(542,276)'~{}?(>mul(854,744))[~~do()]-who()-%-from()how()mul(338,481)how();why()@why()do()}from(){mul(196,713)@+(&^mul(35,164)mul(459,290)how(485,936)]]/";
        String matchRegex = "[^\\s]mul\\(\\d+,\\d+\\)|mul\\(\\d+,\\d+\\)|do\\(\\)|don\\'t\\(\\)";
        String extractRegex = "mul\\((\\d+),(\\d+)\\)";

        Pattern matchPattern = Pattern.compile(matchRegex);
        Pattern extractPattern = Pattern.compile(extractRegex);
        Matcher matcher = matchPattern.matcher(input);

        long total = 0;
        boolean doOperation = true;
        while (matcher.find()) {
            String match = matcher.group();
            if(match.equals("do()")) {
                doOperation = true;
                continue;
            }
            if(match.equals("don't()")) {
                doOperation = false;
                continue;
            }
            Matcher extractMatcher = extractPattern.matcher(match);
            if(doOperation && extractMatcher.find()) {
                long x = Integer.parseInt(extractMatcher.group(1));
                long y = Integer.parseInt(extractMatcher.group(2));
                total += x * y;
            }

        }
        System.out.println("Total: " + total);
    }

}
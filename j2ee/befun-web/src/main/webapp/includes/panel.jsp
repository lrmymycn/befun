<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div id="panel">
	<span class="close"></span>
	<div class="top">
		<div class="title">
			<span id="project-name"></span>
		</div>      			
		<div class="tabs">     			
			<a href="#tab-overview" class="active first">项目图集</a>
			<a href="#tab-details">项目信息</a>
			<a href="#tab-floorplans">户型检索</a>
			<a href="#tab-sales">区域分析</a>
			<a href="#tab-comments">精彩周边</a>
			<a href="#tab-contactus">联系我们</a>
		</div>
	</div>     		
	<div class="content">
		<div id="tab-overview" class="shown tab-block">
			<ul class="brochure">
				
			</ul>
		</div>	
		<div id="tab-details" class="hidden tab-block">
			<div class="tabs">
    			<a href="#subtab-description" class="active">基本信息</a>
    			<a href="#subtab-feature">项目特色</a>
    			<a href="#subtab-finish">内饰品牌</a>
			</div>
			<div id="subtab-description" class="shown detailbox">
				<span class="arrow"></span>
				<div class="detail">
					<table>
						<tr>
							<td width="100"><strong>地址</strong></td>
							<td>661-665 Gardeners Rd Mascot NSW 2020</td>
						</tr>
						<tr>
							<td><strong>市政厅</strong></td>
							<td>Mascot</td>
						</tr>
						<tr>
							<td><strong>市中心距离</strong></td>
							<td>10km</td>
						</tr>
						<tr>
							<td><strong>开发商</strong></td>
							<td>Meriton</td>
						</tr>
						<tr>
							<td><strong>建筑商</strong></td>
							<td>Meriton</td>
						</tr>
						<tr>
							<td><strong>发布日期</strong></td>
							<td>25/05/2013</td>
						</tr>
						<tr>
							<td><strong>总期数</strong></td>
							<td>3</td>
						</tr>
						<tr>
							<td><strong>总栋数</strong></td>
							<td>3</td>
						</tr>
						<tr>
							<td>项目设施</td>
							<td>
								<ul class="amenity">
									<li><i class="tick"></i> Reception</li>
									<li><i class="tick"></i> Swimming Pool</li>
									<li><i class="tick"></i> Sauna Room</li>
									<li><i class="tick"></i> Tennis Court</li>
									<li><i class="tick"></i> Function Room</li>
									<li><i class="tick"></i> Theatre Cinema</li>
									<li><i class="tick"></i> Library</li>
									<li><i class="tick"></i> BBQ Fireplace</li>
									<li><i class="tick"></i> Landscaping</li>
									<li><i class="tick"></i> Sky Garden</li>
									<li><i class="tick"></i> Visitor parking</li>
									<li><i class="tick"></i> Car wash bay</li>
									<li><i class="tick"></i> Gym</li>
									<li><i class="tick"></i> Kids Play Ground</li>
									<li><i class="tick"></i> Play Room</li>
									<li><i class="tick"></i> Recreation Place</li>
									<li><i class="tick"></i> Music Room</li>
								</ul>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div id="subtab-feature" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					<ol>
						<li><p><strong>最好的地理位置</strong><br/>
						EON位于Zetland，一个全新充满活力的内城区，距离市中心仅3.8公里的距离，被市政厅规划为将来作为市中心City South的南向延伸。距离东部Boundi Beach和Googee Beach5公里距离；距离机场4公里；距离新南威尔士大学1.8公里；距离悉尼大学和UTS3公里。</p></li>
						<li><p><strong>便捷的交通通勤</strong><br/>
						从EON项目步行8分钟到Green Square火车站，搭乘火车仅需数分钟可达市区。楼下50米汽车站，多趟不同的公交线路提供北线到到市区，西线Wolli Creek，东线Bondi Junction的公交通勤服务。自驾车15分钟以内到达东部海滩，2分钟到达新南威尔士大学，10分钟到达悉尼机场。如此便利的公共交通，在悉尼首屈一指。</p></li>
						<li><p><strong>政府支持</strong><br/>
						Zetland受益于悉尼政府17亿的City南线Green Square改造计划。总面积达278公顷，整个区域将达到三万三千人的居住规模，并提供二万八千个工作机会，Green Square改造计划将让Zetland成为巨大的现化型商业住宅中心。2012年12月13日，NSW政府宣布投资16亿，建设连接悉尼东部城区和Circular Quay的轻轨，当建成通车之后，Zetland会成为真正的10 minutes to anywhere的王者城区，其交通枢纽的地位，无可匹敌。</p></li>
						<li><p><strong>巨大的天然氧吧</strong><br/>
						Zetland毗邻的Moore Park和Centennial park是悉尼的“纽约中央公园“。Moore Park占地115公顷，Centenial Park占地189公顷。公园拥有高尔夫球场，运动场，跑马场，院内湖泊，烧烤场地等齐全设施。这无尽的植被覆盖和绿色生态圈，离EON仅仅1公里的距离而已。</p></li>
						<li><p><strong>丰富教育资源</strong><br/>
						周边有私立高中Taylor College, NSW排名四的Sydney Boys High, NSW排名第六的Sydney Girls High。大学有新南威尔士大学，悉尼大学和悉尼科技大学。</p></li>
						<li><p><strong>商业购物</strong><br/>
						2014年，大型购物中心Eastvillage将落成，该购物中心距离EON仅有400米的距离。连锁超市巨头Coles将会入驻。跟随Coles入驻的将有100家以上的精品和美食商家。Eastvillage将成为Zetaland居民的购物天堂。</p></li>
						<li><p><strong>稳定的投资回报</strong><br/>
						四通八达的交通决定了其低级的空置率和高于悉尼平均收益的房租回报率。Zetland的常住人口包括学校周边的在校学生，在CBD工作的年轻白领，各行业的专业人士以及在机场工作的空勤人员。1.3%的空置率低于澳洲平均3%，属于非常有利于房东的租务市场。房租平均每年增长5%高于CPI和银行贷款利息。Zetland房产的价值将会随着悉尼轻轨建设的展开和Green Square开发的深化而逐年攀升。</p></li>
					</ol> 
				</div>
			</div>
			<div id="subtab-finish" class="hidden detailbox">
				<span class="arrow"></span>
				<div class="detail">
					<table>
						<tr>
							<td width="100"><strong>Wall</strong></td>
							<td>Painted Plasterboard</td>
						</tr>
						<tr>
							<td><strong>Floor</strong></td>
							<td>Carpet / Timber floor</td>
						</tr>
						<tr>
							<td><strong>Kitchen</strong></td>
							<td>Splashback (stone/nature stone)<br/>
								Cooktop (brand)<br/>
								Oven (brand)<br/>
								Rangehood (brand, ducted/recirculating)<br/>
								Dishwasher (brand)<br/>
								Microwave (brand)<br/>
								Sink (brand or material)
							</td>
						</tr>
						<tr>
							<td><strong>Bathroom</strong></td>
							<td>Shower (brand or material)<br/>
								Tub (brand)<br/>
								Tile (ceramic tiles)<br/>
								Bathroom ware (brand)
							</td>
						</tr>
						<tr>
							<td><strong>Aircon</strong></td>
							<td>Centralized</td>
						</tr>
						<tr>
							<td><strong>NBN</strong></td>
							<td>What's this?</td>
						</tr>
						<tr>
							<td><strong>Satellite TV</strong></td>
							<td>Foxtel</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div id="tab-floorplans" class="hidden">
			<jsp:include page="floorplan_filter.jsp" />
			<div id="floorplans">
				<!--<div class="title">Search Results:</div>-->
				<div id="floorplan-list">
					<a href="javascript:;" class="prev nav"></a>
					<div class="scrollable">
						<div class="items">
							
						</div>
					</div>
					<a href="javascript:;" class="next nav"></a>
				</div>
			</div>
		</div>
		<div id="tab-sales" class="hidden tab-block">
			<div class="box">
				<p>Zetland所在地Green Square, 城区南延线, 明日之星, 增长迅速</p>
				<ol>
					<li><p><strong>悉尼内城区大型重建新区</strong><br/>
					自1990年代开始发展的内城新区Green Square, 是悉尼南延线的市区重建计划, 由原来的货仓工业区蜕变成为时尚的商业新区, 未来可以提供多达2万套全系住宅. Zetland占据Green Square的核心位置, 除了临近悉尼CBD, 于3间著名大学亦只有10分钟的车程, 新楼盘对物业投资者, 年轻的专业人士和海外留学生均有很大的吸引力. Green Square覆盖多个城区, 包括Zetaland(2017),  Beaconsfiled(2017), Rosebery(2018), Waterloo(2017), Alexandria(2015)以及St Peter的部分地段</p>
					</li>
					<li><p><strong>毗邻商业和教育中心, 占据黄金位置</strong><br/>
					以Zetland为中心, 驾车前往CBD和悉尼机场的车程仅为10分钟, 前往新南威尔士大学仅需3分钟,  前往靠近City的悉尼大学和悉尼科技大学仅需10分钟. 在这个内城区新区, 即将落成的住宅以公寓为主, 1房主要针对海外留学生和年轻的专业人士, 两房主要针对投资者和年轻的家庭.<br/>
					坐落在Zetland中心位置的East Village大型项目, 由大型开发商Payce耗资3亿澳币打造. East Village底层是占地9000平方米的新鲜食品广场以及50间以上的精品零售店, 项目中层部分将兴建澳洲首个”空中花园”, 面积达6500平方米.  Payce还提供豪华温水Spa, 健身房以及休闲凉亭供住户使用.</p>
					</li>
					<li><p><strong>备受新移民青睐, 人口年增长6%</strong><br/>
					Green Square在2006年有大约1.5万人居住, 到2021年预计会增加至超过3.5万人. 年平均增长6%, 超过悉尼市的平均人口增加速度.<br/>
					25-29岁年轻居民最多, 让整个城区充满活力. 从2006到2013年期间, Green Square家庭数目估计会增加10500个, 而每户的平均人数会从2.20降至2.15. 由于吸引了大量年轻夫妇和单身贵族的入住, 该区二人世界小家庭约占3成. <br/>
					Green Square城区临近CBD商圈, 提供很多就业机会. 在Beaconsfield, Zetland和Alexandria均聚集了许多专业人士, 中高收入家庭的比率亦高过悉尼平均. Zetland专业人士比率占到34%; Beaconsfield专业人士比率为31%, Alexandria的专业人士比率更高达36. 均高于悉尼的平均率24%. Zetland有26%的家庭每周收入达到2500元, Beaconsfield的比率是27%, Alexandria为26%. 这三个城区的比率都高于悉尼平均的17%.
					</p></li>
					<li><p><strong>政府宣布Green Square Town Centre计划, 打造城中城.</strong><br/>
					Green Square区内的一项大型工程项目Green Square Town Centre, 将是Green Square发展的核心所在. 此项目包含了住宅, 商业, 零售和文化项目, 完成后可容纳5850名居民和9300名就业人口. Zetland毗邻Town Centre, 是Green Square Town Centre Master Plan的最大收益地区.<br/>
					按照计划, Green Square市中心的零售空间会分为3部分, 分别是时尚, 餐饮和新鲜食品地带, 并以步行街把这3部分连接起来, 让生活更添便利.<br/>
					在Town Centre落成前, Green Square也有相当多的购物地段. Zetland的East Village给Zetland提供超市, 餐馆和零售店铺; Waterloo的Dank Street有Coles超市和精品咖啡馆;  Alexandria有各式仓储式卖场和展销中心; 临近的Newtown和Surry Hills有着最富有悉尼风情的特色咖啡馆和精品时尚店. <br/>
					休闲设施方面, Green Square将会打造一个全新的泳池, 并会兴建一座新的图书馆和社区中心. 处于Green Square市中心的广场Green Square Plaza, 占地4200平方米. 此外区内还会新建两个公园, 其中一个面积达到5000平方米.</p></li>
					<li><p><strong>四通八达的交通, 东南西北近在咫尺</strong><br/>
					Zetland距离Green Square火车站仅有500米. Green Square火车站平均每10-15分钟开出一趟火车, 北向仅需5分钟就达到悉尼市中心 (Central Station), 13分钟到达环形码头 (Circular Quay) 和悉尼歌剧院, 南向6分钟达到国内机场, 8分钟到达国际机场. <br/>
					2012年12月, NSW州长宣布由悉尼东区到环形码头的轻轨项目正式启动, 该项目将穿过Zetland. 届时从Zetland到东区Randwick仅需10分钟.<br/>
					多条bus线路穿过Zetland. 343, 370, 345, 301以及M20.</p></li>
				</ol>
			</div>
		</div>
		<div id="tab-comments" class="hidden tab-block">
			<div class="box">
				<div id="add-comment">
					<a href="#">+ 发表我的看法</a>
				</div>
				<ul>
					<li>
						<div class="name">Sam <span class="date">Jun 20, 2013</span></div>
						<div class="comment"><p>附近住个奇怪的大叔喜欢穿着风衣吓人。好可怕。</p></div>
					</li>
					<li>
						<div class="name">Ryan <span class="date">Jun 20, 2013</span></div>
						<div class="comment"><p>那一天，人類終於回想起了，曾經一度支配他們的恐懼，還有被囚禁於鳥籠中的屈辱。</p></div>
					</li>
					<li>
						<div class="name">Bourne <span class="date">May 19, 2013</span></div>
						<div class="comment"><p>杰森·伯恩在意大利被人从海上救起，他失去了记忆，除了臀部的瑞士银行帐号之外，他完全没有办法证明自己的身份。</p>
<p>杰森从瑞士银行找到了大量的现金，六本护照，一把枪，同时他发现自己格斗、枪械、和语言等方面的能力，他开始追查自己的身份，并且把陌生女子玛丽也卷了进来。两人从瑞士到巴黎，一路上受到神秘杀手组织的追杀，危机重重。</p>
<p>杰森能否化险为夷，找到自己的真实身份？他是否有勇气面对真相？</p></div>
					</li>
				</ul>
			</div>
		</div>
		<div id="tab-contactus" class="hidden tab-block">
			<div class="box">
				<p><strong>价格? 数据? 走势? 楼盘对比? 如果您想了解更多，我们会第一时间给答复给您：</strong></p>
				<form action="" method="post">
					<div class="row clearfix">
						<span class="title">项目:</span>
						<div class="input">
							<span class="project">Oceanvale</span>
							<input id="hfproject" type="hidden" value=""/>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">姓名*:</span>
						<div class="input">
							<input type="text" name="name" value="" class="required"/>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">Email*:</span>
						<div class="input">
							<input type="email" name="email" value="" class="required"/>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">手机:</span>
						<div class="input">
							<input type="text" name="mobile" value=""/>
						</div>
					</div>
					<div class="row clearfix">
						<span class="title">留言:</span>
						<div class="input">
							<textarea placeholder="例如：关于这个项目，我想了解更多。"></textarea>
						</div>
					</div>
					<div class="buttons">
						<input type="submit" class="btn red" value="提交"></a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
package com.systems88.memberbalance.core;

import com.systems88.memberbalance.core.persistence.entities.member.MemberMicro;
import com.systems88.memberbalance.core.persistence.entities.member.MemberWft;

@SuppressWarnings("rawtypes")
public enum GameProviderMember {

	MICRO					("1005", MemberMicro.class),
//	AG						("1012", MemberAg.class),
//	CMD						("1018", MemberCmd.class),
//	OG						("1023", MemberOg.class), 
//	GP						("1027", MemberGp.class), 
//	OPUS					("1030", MemberOpus.class), 
//	OPUSSB					("1031", MemberOpusSport.class),
//	GPSB					("1033", MemberGpSport.class), 
//	GP_BETSOFT				("1034", MemberGpBetsoft.class), 
//	TAISHAN					("1035", MemberTaishan.class), 
//	MTEG					("1036", MemberMicroTotalegaming.class), 
//	HAB						("1037", MemberHabanero.class), 
//	PTJK					("1038", MemberPtJpykrw.class), 
//	ABJK					("1039", MemberAbJpykrw.class), 
//	TAISHAN1040				("1040", MemberTaishan1040.class),
//	PTC						("1044", MemberPtCny.class),
//	AG_CNY					("1045", MemberAgCny.class),
//	GOLDENRACE				("1048", MemberGoldenrace.class),
//	SKYCITY_BETEAST			("1049", MemberSkyCityBeteast.class),
//	PORNHUB					("1050", MemberPornhub.class),
//	ALLBET1051				("1051", MemberAllbet1051.class),
//	BBIN					("1052", MemberBbin.class),
//	NETENT					("1053", MemberNetent.class),
//	ONEWORKSIBC				("1054", MemberOneworksibc.class),
//	GGAMING					("1055", MemberGg.class),
//	UG						("1056", MemberUg.class),
//	TCGLOTTO				("1057", MemberTcglotto.class),
//	ODDSKING				("1059", MemberOddsking.class),
//	PINNACLE				("1060", MemberPinnacle.class),
//	FLOWGAMING_NGO			("1061", MemberFlowgamingPlayongo.class),
//	FLOWGAMING_QUICKSPIN	("1062", MemberFlowgamingQuickspin.class),
//	BUSTABIT				("1064", MemberBustabit.class),
//	PRAGMATIC				("1065", MemberPragmatic.class),
//	HABANERO_APLUS			("1066", MemberHabaneroAplus.class),
//	HYDAKO					("1067", MemberHydako.class), 
//	A_SPORT					("1068", MemberAsport.class),
//	LOTUS_APLUS				("1069", MemberLotusAplus.class),
//	IDNPOKER				("1070", MemberIdnPoker.class), 
//	COILING_DRAGON			("1071", MemberCoilingDragon.class), 
//	SKYCITY_EVOLUTION		("1072", MemberSkyCityEvolution.class),
//	SKYCITY_SKYCITYMINI		("1073", MemberSkyCityMini.class),
//	I_SPORT					("1074", MemberIsport.class),
//	S_SPORT					("1075", MemberSsport.class),
	WFT						("1076", MemberWft.class);
//	MICROSLOT				("1077", MemberMicroSlot.class),
//	MUAYTHAI				("1078", MemberMuayThai.class), 
//	RTG						("1079", MemberRtg.class),
//	SPADE					("1080", MemberSpade.class),
//	EBET					("1081", MemberEbet.class),
//	PLAYSON					("1082", MemberFlowgamingPlayson.class),
//	LEANDER					("1083", MemberFlowgamingLeander.class),
//	ELK						("1084", MemberFlowgamingELK.class),
//	NOLIMITCITY				("1085", MemberFlowgamingNoLimitCity.class),
//	FLOWGAMING_NETENT		("1087", MemberFlowgamingNetent.class),
//	FLOWGAMING_MICRO		("1088", MemberFlowgamingMicro.class);

	private String id;
	private Class clazz;

	private GameProviderMember(String id, Class clazz) {
		this.id = id;
		this.clazz = clazz;
	}

	public String getId() {
		return id;
	}

	public Class getClazz() {
		return clazz;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static GameProviderMember getGameProviderMemberClassBy(String id) {

		for (GameProviderMember gp : GameProviderMember.values()) {
			if (gp.getId().equals(id)) {
				return gp;
			}
		}

		return null;
	}

}

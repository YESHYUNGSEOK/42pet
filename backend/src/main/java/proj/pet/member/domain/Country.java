package proj.pet.member.domain;

import lombok.Getter;

import java.util.List;

@Getter
public enum Country {
	ARMENIA(Campus.YEREVAN),
	AUSTRALIA(Campus.ADELAIDE),
	AUSTRIA(Campus.VIENNA),
	BELGIUM(Campus.NINE_TEEN),
	BRAZIL(Campus.RIO_DE_JANEIRO, Campus.SAO_PAULO),
	CANADA(Campus.QUEBEC),
	CZECH(Campus.PRAGUE),
	ETC,
	FINLAND(Campus.HELSINKI),
	FRANCE(Campus.LE_HAVRE, Campus.PERPIGNAN, Campus.MULHOUSE, Campus.NICE, Campus.LYON, Campus.PARIS, Campus.ANGOULEME),
	GERMANY(Campus.BERLIN, Campus.WOLFSBURG, Campus.HELIBRONN),
	ITALY(Campus.FLORENCE, Campus.ROME),
	JAPAN(Campus.TOKYO),
	KOREA(Campus.GYEONGSAN, Campus.SEOUL),
	LUXEMBOURG(Campus.LOUXEMBOURG),
	MALAYSIA(Campus.KUALA_LUMPUR),
	MOLDOVA(Campus.CHISINAU),
	MOROCCO(Campus.TETOUAN, Campus.BENGUERIR, Campus.KHOURIBGA),
	NETHERLANDS(Campus.AMSTERDAM),
	PORTUGAL(Campus.PORTO, Campus.LISBOA),
	ROMANIA(Campus.CLUJ, Campus.BUCHAREST),
	RUSSIA(Campus.KAZAN, Campus.MOSCOW),
	SINGAPORE(Campus.SINGAPORE),
	SOUTH_AFRICA(Campus.JOHANNESBURG, Campus.CAPE_TOWN),
	SPAIN(Campus.BARCELONA, Campus.URDULIZ, Campus.MALAGA, Campus.MADRID),
	SWITZERLAND(Campus.LAUSANNE),
	THAILAND(Campus.BANGKOK),
	TURKEY(Campus.KOCAELI, Campus.ISTANBUL),
	UAE(Campus.ABU_DHABI),
	UK(Campus.LONDON),
	UKRAINE(Campus.KYIV),
	USA(Campus.FREMONT),
	;

	private final List<Campus> campuses;

	Country(Campus... campuses) {
		this.campuses = List.of(campuses);
	}

	public static Country from(String country) {
		return Country.valueOf(country.toUpperCase());
	}

	public enum Campus {
		GYEONGSAN("Gyeongsan", "42gyeongsan.kr"),
		SEOUL("Seoul", "42seoul.kr"),
		SINGAPORE("Singapore", "42singpapore.sg"),
		LE_HAVRE("Le Havre", "42lehavre.fr"),
		PERPIGNAN("Perpignan", "42perpignan.fr"),
		LOUXEMBOURG("Luxembourg", "42luxembourg.lu"),
		PORTO("Porto", "42porto.com"),
		LONDON("London", "42london.com"),
		PRAGUE("Prague", "42prague.com"),
		TETOUAN("Tétouan", "1337.ma"),
		VIENNA("Vienna", "42vienna.com"),
		FLORENCE("Florence", "42firenze.it"),
		BERLIN("Berlin", "42berlin.de"),
		KOCAELI("Kocaeli", "42kocaeli.com.tr"),
		ISTANBUL("Istanbul", "42istanbul.com.tr"),
		MULHOUSE("Mulhouse", "42mulhouse.fr"),
		LAUSANNE("Lausanne", "42lausanne.ch"),
		BARCELONA("Barcelona", "42barcelona.com"),
		WOLFSBURG("Wolfsburg", "42wolfsburg.de"),
		ABU_DHABI("Abu Dhabi", "42abudhabi.ae"),
		FT_NETWORK("42Network", "42network.org"), // France staff로 추정
		NICE("Nice", "42nice.fr"),
		URDULIZ("Urduliz", "42urduliz.com"),
		LYON("Lyon", "42lyon.fr"),
		KYIV("Kyiv", "unit.ua"),
		FREMONT("Fremont", "42.us.org"),
		JOHANNESBURG("Johannesburg", "wethinkcode.co.za"),
		CLUJ("Cluj", ""),
		PARIS("Paris", "42.fr"),
		HELIBRONN("Heilbronn", "42heilbronn.de"),
		LISBOA("Lisboa", "42lisboa.com"),
		MALAGA("Malaga", "42malaga.com"),
		ADELAIDE("Adelaide", "42adel.org.au"),
		KUALA_LUMPUR("Kuala Lumpur", "42kl.edu.my"),
		BANGKOK("Bangkok", "42bangkok.com"),
		YEREVAN("Yerevan", "42yerevan.am"),
		ANGOULEME("Angoulême", "42angouleme.fr"),
		ROME("Rome", "42roma.it"),
		RIO_DE_JANEIRO("Rio de Janeiro", "42.rio"),
		TOKYO("Tokyo", "42tokyo.jp"),
		QUEBEC("Quebec", "42quebec.com"),
		KAZAN("Kazan", "21-school.ru"),
		MADRID("Madrid", "42madrid.com"),
		BENGUERIR("Benguerir", "1337.ma"),
		SAO_PAULO("São-Paulo", "42sp.org.br"),
		MOSCOW("Moscow", "21-school.ru"),
		KHOURIBGA("Khouribga", "1337.ma"),
		CAPE_TOWN("Cape-Town", "wethinkcode.co.za"),
		AMSTERDAM("Amsterdam", "codam.nl"),
		HELSINKI("Helsinki", "hive.fi"),
		NINE_TEEN("19", "s19.be"), // BELGIUM - BRUSSELS
		BUCHAREST("Bucharest", ""),
		CHISINAU("Chisinau", ""),
		;


		private final String name;
		private final String emailExtension;

		Campus(String name, String emailExtension) {
			this.name = name;
			this.emailExtension = emailExtension;
		}
	}
}

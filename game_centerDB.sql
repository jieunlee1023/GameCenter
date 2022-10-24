
USE game_center;



CREATE DATABASE game_center;

CREATE TABLE user(
	identityNum INT NOT NULL,
	userId VARCHAR(10) NOT NULL,
    password VARCHAR(20) NOT NULL,
    userName VARCHAR(6) NOT NULL,
    email VARCHAR(25),
    mobile VARCHAR(15),
    PRIMARY KEY(userId)
);

INSERT INTO user VALUES (1, 'A', 'asd1234', '관리자', NULL, NULL);
INSERT INTO user VALUES (2, 'ji_euni', '123', '이지은', 'ji_euni@naver.com', '010-8327-9660');
INSERT INTO user VALUES (2, 'binstarr', '123', '강성빈', 'binstarr@naver.com', NULL);
INSERT INTO user VALUES (2, 'min', '123', '김경민', NULL, '010-6709-7992');

SELECT * FROM user;
SELECT * FROM gameCenterInfo;
SELECT * FROM gameInfo;
SELECT * FROM gameCharacter;
SELECT * FROM gameMap;

-- DELETE FROM user;

CREATE TABLE gameCenterInfo(
	gameName VARCHAR(13) NOT NULL,
    PRIMARY KEY(gameName)
);

INSERT INTO gameCenterINfo VALUES ('롤');
INSERT INTO gameCenterINfo VALUES ('피파온라인4');
INSERT INTO gameCenterINfo VALUES ('크레이지아케이드');

CREATE TABLE gameInfo(
	gameName VARCHAR(13) NOT NULL,
    ageLimit INT,
    gameInfo LONGTEXT NOT NULL,
    PRIMARY KEY(gameName),
    FOREIGN KEY(gameName) REFERENCES gameCenterInfo(gameName)
);

INSERT INTO gameInfo VALUES ('롤', 15, '《리그 오브 레전드》는 라이엇 게임즈에서 개발...');
INSERT INTO gameInfo VALUES ('피파온라인4', 15, '《FIFA 온라인 4》는 2018년 상반기 출시한 넥슨의 스포츠...');
INSERT INTO gameInfo VALUES ('크레이지아케이드', 10, '《크레이지 아케이드》는 로두마니 스튜디오가 개발...');

CREATE TABLE gameCharacter(
	gameName VARCHAR(13) NOT NULL,
    gameCharacterName VARCHAR(10) NOT NULL,
    gameCharacterInfo LONGTEXT NOT NULL,
    PRIMARY KEY (gameCharacterName),
    FOREIGN KEY (gameName) REFERENCES gameInfo(gameName)
);


INSERT INTO gameCharacter VALUES ('롤', '야스오', '야스오는 어린 시절 마을 사람들이 자신에 대해 하는 말을...');
INSERT INTO gameCharacter VALUES ('롤', '제드', '조화로운 아이오니아의 이면에는 버려진 자들의 이야기가...');

INSERT INTO gameCharacter VALUES ('피파온라인4', '박주영', '클럽에서는 2005 시즌 FC 서울에서 18골을 득점하며 신인왕을 수상...');
INSERT INTO gameCharacter VALUES ('피파온라인4', '손흥민', '프리미어 리그와 UEFA 챔피언스 리그 아시아 선수 역대 최다 득점자이자 최초로 발롱도르...');

INSERT INTO gameCharacter VALUES ('크레이지아케이드', '우니', '주연 8인방 중 가장 어리고, 공갈젖꼭지를...');
INSERT INTO gameCharacter VALUES ('크레이지아케이드', '배찌', '성장형 캐릭터로 추정된다. 카트라이더 공식 소개를 보면 실력에 발전 가능이...');

CREATE TABLE gameMap(
	gameName VARCHAR(13) NOT NULL,
    gameMapName VARCHAR(10) NOT NULL,
    gameMapInfo LONGTEXT NOT NULL,
    PRIMARY KEY (gameMapName),
    FOREIGN KEY (gameName) REFERENCES gameInfo(gameName)
);

INSERT INTO gameMap VALUES ('롤', '소환사의 협곡', '특별한 이벤트 형식이 아닌 이상 대부분의 공식대회에서 지원하는 사실상...');
INSERT INTO gameMap VALUES ('롤', '칼바람 나락', '중립 지역이 없고 공격로가 단 하나다. 그래서 다른 맵들과 다르게...');

INSERT INTO gameMap VALUES ('피파온라인4', '에스타티오 산티아고', '100년이 넘은 홈구장 화이트 하트 레인의 노후화 때문에 토트넘은 새로운...');
INSERT INTO gameMap VALUES ('피파온라인4', '올드 트래포드', '서울특별시 마포구 성산동에 위치한 축구장. 2002 FIFA 월드컵 한국·일본을 위해 건설된 아시아에서 2번째...');

INSERT INTO gameMap VALUES ('크레이지아케이드', '패트릿', '짐상자를 가득 실은 해적선. 해적선답게 각종 아이템이 드롭...');
INSERT INTO gameMap VALUES ('크레이지아케이드', '캠프', '이름은 캠프지만 군부대 시설을 모티브로 한 맵으로 군대 무늬 장애물이 널려있으며...');

SELECT * 
FROM gameInfo AS A
JOIN gameCenterInfo AS B
JOIN gameCharacter AS C
JOIN gameMap AS D
ON A.gameName = B.gameName AND A.gameName = C.gameName AND A.gameName = D.gameName;
-- drop database game_center;

select * from gameinfo;
select * from gamemap;
select * from gamecharacter;

-- delete from gamemap where gameName ='피파온라인4';

INSERT INTO gameCharacter VALUES ('피파온라인4', '호나우두', '클럽에서는 2005 시즌 FC 서울에서 18골을 득점하며 신인왕을 수상...');
INSERT INTO gameCharacter VALUES ('피파온라인4', '리오넬 메시', '프리미어 리그와 UEFA 챔피언스 리그 아시아 선수 역대 최다 득점자이자 최초로 발롱도르...');
INSERT INTO gameCharacter VALUES ('피파온라인4', '카림 벤제마', '프리미어 리그와 UEFA 챔피언스 리그 아시아 선수 역대 최다 득점자이자 최초로 발롱도르...');
INSERT INTO gameCharacter VALUES ('피파온라인4', '손흥민', '프리미어 리그와 UEFA 챔피언스 리그 아시아 선수 역대 최다 득점자이자 최초로 발롱도르...');


UPDATE gameinfo SET gameinfo ='넥슨에서 2001년 9월에 런칭한 온라인 게임이다. 
넥슨의 크레이지 시리즈 중에서 가장 장수한 작품으로
2021년 기준으로 무려 20주년을 맞이하고 있다.
크레이지 아케이드라는 이름답게, 테트리스, 틀린그림찾기 등 
오락실에서 볼 수 있을 법한 다양한 장르를 서비스했었다. 
초창기 게임 콘셉트도 아예 오락실을 온라인화하겠다는 것이었고, 
타이틀 화면부터가 아케이드 게임기 캐릭터 모양이었으니. 
하지만 다른 게임 개발 업체들에 관광당한 이후 
그나마 제일 인기가 있었던 BnB만 서비스하였다.
그래서 크레이지 아케이드는 곧 BnB 그 자체며, 
이는 히든캐치가 부활했음에도 여전하다.' 
where gamename = '크레이지아케이드';


insert into gamecharacter values ('크레이지아케이드', '계피', '계피의 정보');
insert into gamecharacter values ('크레이지아케이드', '다오', '다오의 정보');

insert into gamemap values ('크레이지아케이드', '패트릿', '짐상자를 가득 실은 해적선. 해적선답게 각종 아이템이 드롭된다.
가장 인기있는 맵은 패트릿 14이며, 국민맵이라고 불리는 맵이다.');
insert into gamemap values ('크레이지아케이드', '팩토리', '각종 물풍선을 만드는 공장. 붐힐의 동쪽에 있는 곳이다. 공장답게 블럭 일부가 박스 모양이며 트랩, 산소통 아이템이 뜬다.
최초로 특수 아이템이 등장한 맵이다.');
insert into gamemap values ('크레이지아케이드', '캠프', '이름은 캠프지만 군부대 시설을 모티브로 한 맵으로 군대 무늬 장애물이 널려있으며 내구도가 최대 5인 단단한 상자도 나온다. 
이 나무 상자를 부수면 높은 확률로 물풍선을 펑펑 쏴대는 탱크를 얻을 수 있다.');
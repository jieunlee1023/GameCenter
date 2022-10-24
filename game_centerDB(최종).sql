USE game_center;
CREATE DATABASE game_center;
-- drop database game_center;
CREATE TABLE user(
	identityNum INT NOT NULL,
	userId VARCHAR(10) NOT NULL,
    password VARCHAR(20) NOT NULL,
    userName VARCHAR(6) NOT NULL,
    email VARCHAR(25),
    mobile VARCHAR(15),
    PRIMARY KEY(userId)
);

INSERT INTO user VALUES (1, 'A', '1', '관리자', NULL, NULL);
INSERT INTO user VALUES (2, 'ji_euni', '123', '이지은', 'ji_euni@naver.com', '010-8327-9660');
INSERT INTO user VALUES (2, 'binstarr', '123', '강성빈', 'binstarr@naver.com', NULL);
INSERT INTO user VALUES (2, 'min', '123', '김경민', NULL, '010-6709-7992');

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

INSERT INTO gameInfo VALUES ('롤', 15, '《리그 오브 레전드》라이엇 게임즈가 개발 및 서비스 중인 MOBA 장르의 게임. 
게임 명칭의 앞 철자들을 따서 LoL(롤), 영어권에서는 League 등의 약칭으로도 불린다.
이전까지 있었던 MOBA(AOS) 게임들보다 진입 장벽을 낮추는 것으로 
높은 인기를 얻었고 현재는 전 세계에서 많은 유저들을 보유중인데
PC 게임 중 전 세계에서 많이 플레이하는 게임 중 하나이며 
2016년 기준 월 플레이어 수 1억 명 이상을 달성했고,
 2019년 8월 기준 하루 전 세계 서버의 피크 시간 동시 접속자 수를 합치면
800만 명 이상이다.');
INSERT INTO gameInfo VALUES ('피파온라인4', 15, '《FIFA 온라인 4》는 
2018년 5월 17일에 서비스를 시작한 FIFA 온라인 4 (EA Sports™ FIFA Online 4 또는 FIFA Online 4, 이하 피파 온라인 4)는 
EA 산하의 EA 코리아 스튜디오(구 스피어헤드)에서 개발하고 넥슨이 배급하는 피파 온라인 3의 후속작이다. 피파 18을 원작으로 두고 있다. 
2017년 11월 2일에 열린 EA x 넥슨 뉴 프로젝트 미디어 쇼케이스 에서 처음으로 공개되었다.');
INSERT INTO gameInfo VALUES ('크레이지아케이드', 10, '넥슨에서 2001년 9월에 런칭한 온라인 게임이다. 
넥슨의 크레이지 시리즈 중에서 가장 장수한 작품으로
2021년 기준으로 무려 20주년을 맞이하고 있다.
크레이지 아케이드라는 이름답게, 테트리스, 틀린그림찾기 등 
오락실에서 볼 수 있을 법한 다양한 장르를 서비스했었다. 
초창기 게임 콘셉트도 아예 오락실을 온라인화하겠다는 것이었고, 
타이틀 화면부터가 아케이드 게임기 캐릭터 모양이었으니. 
하지만 다른 게임 개발 업체들에 관광당한 이후 
그나마 제일 인기가 있었던 BnB만 서비스하였다.
그래서 크레이지 아케이드는 곧 BnB 그 자체며, 
이는 히든캐치가 부활했음에도 여전하다.');

CREATE TABLE gameCharacter(
	gameName VARCHAR(13) NOT NULL,
    gameCharacterName VARCHAR(10) NOT NULL,
    gameCharacterInfo LONGTEXT NOT NULL,
    PRIMARY KEY (gameCharacterName),
    FOREIGN KEY (gameName) REFERENCES gameInfo(gameName)
);

-- 롤
INSERT INTO gameCharacter VALUES ('롤', '야스오', '원거리 마법사 챔피언급의
낮은 체력과 방어력을
갖고 있다.');
INSERT INTO gameCharacter VALUES ('롤', '럭스', '패시브 활용을 위해 기본 공격
모션은 간결하고 좋은 편이다.');
INSERT INTO gameCharacter VALUES ('롤', '아펠리오스', '유리대포. 원거리 딜러
기준에서 공격 스탯이 준수한 
편이다');
INSERT INTO gameCharacter VALUES ('롤', '쓰레쉬', '리그 오브 레전드 최초의 루팅
챔피언으로
성장 방어력이 0이다.');
-- 피파
INSERT INTO gameCharacter VALUES ('피파온라인4', '호나우두', '브라질의 前 축구선수이자 現 레알 바야돌리드 CF 회장 겸 크루제이루 EC의 구단주이며 현역 시절 두 번의 월드컵을 포함해 다섯 번의 국제대회 우승 및 바르셀로나, 인테르, 레알 마드리드를 거치며 발롱도르를 2회, FIFA 올해의 선수를 3회 수상한 선수이다.');
INSERT INTO gameCharacter VALUES ('피파온라인4', '리오넬 메시', '아르헨티나 국적의 파리 생제르맹 FC 소속 축구선수. 포지션은 공격수. 현재 아르헨티나 축구 국가대표팀 주장을 맡고 있다. 발롱도르, FIFA 올해의 선수, 유러피언 골든슈 최다 수상자이자 FC 바르셀로나, 아르헨티나 축구 국가대표팀, 라리가 역대 최다 득점자이다.');
INSERT INTO gameCharacter VALUES ('피파온라인4', '카림 벤제마', '프랑스 대표팀에서도 2015년까지 주전 스트라이커로 활약하였으나, 불미스러운 사건으로 인해 퇴출되었다가 UEFA 유로 2020을 통해 국가대표팀에 복귀했고, 2020-21 UEFA 네이션스 리그에서 국가대표 첫 우승을 차지했다.그리고 2022년, 2021-22 시즌의 활약을 바탕으로 생애 첫 발롱도르를 수상하게 되었다.');
INSERT INTO gameCharacter VALUES ('피파온라인4', '손흥민', '프리미어 리그와 UEFA 챔피언스 리그 아시아 선수 역대 최다 득점자이자 최초로 발롱도르 후보 30인과 FIFA FIFPro 월드 XI 후보 55인에 선정됐다. 또한 FIFA 푸스카스상을 수상했으며, 프리미어 리그 이달의 선수에 3회 선정되었고, 아시아 선수 최초로 PFA 올해의 팀 선정 및 프리미어 리그 득점왕에 등극해 골든부트를 수상했다.');
-- 크아
INSERT INTO gameCharacter VALUES ('크레이지아케이드', '우니', '주연 8인방 중 가장 어리고, 공갈젖꼭지를 물고 있다.');
INSERT INTO gameCharacter VALUES ('크레이지아케이드', '배찌', '크레이지 파크의 마스코트격 캐릭터이다.');
INSERT INTO gameCharacter VALUES ('크레이지아케이드', '계피', '주연 8인방 중 가장 통통한 체격이며, 먹는것을 밝히고 착하고 우유부단한 성격');
INSERT INTO gameCharacter VALUES ('크레이지아케이드', '다오', '파란 헬멧과 옷, 그리고 벨트를 항상 차고 있는 소년');

CREATE TABLE gameMap(
	gameName VARCHAR(13) NOT NULL,
    gameMapName VARCHAR(30) NOT NULL,
    gameMapInfo LONGTEXT NOT NULL,
    PRIMARY KEY (gameMapName),
    FOREIGN KEY (gameName) REFERENCES gameInfo(gameName)
);

-- 롤맵
INSERT INTO gameMap VALUES ('롤', '소환사의 협곡', '대표적 전장 / 가장 많은 플레이어들이 선호한다');
INSERT INTO gameMap VALUES ('롤', '칼바람 나락', '칼바람 나락은 
프렐요드에서도 가장 춥고
척박한땅에 자리잡은,
바닥을
가늠할 수 없는 협곡입니다.');
INSERT INTO gameMap VALUES ('롤', '수정의 상처', '캘러맨다의 광산촌인 수정의
상처는무궁무진한 자원이
묻힌 곳입니다.');
-- 피파맵
INSERT INTO gameMap VALUES ('피파온라인4', '스페인 마드리드에 위치', '레알 마드리드 CF의 홈구장.');
INSERT INTO gameMap VALUES ('피파온라인4', '영국 트래포드 맷 버스비', '프리미어 리그 맨체스터 유나이티드 FC의 홈 경기장');

-- 크아맵
INSERT INTO gameMap VALUES ('크레이지아케이드', '패트릿', '짐상자를 가득 실은 해적선. 해적선답게 각종 아이템이 드롭된다.가장 인기있는 맵은 패트릿 14이며, 국민맵이라고 불리는 맵이다.');
INSERT INTO gameMap VALUES ('크레이지아케이드', '캠프', '이름은 캠프지만 군부대 시설을 모티브로 한 맵으로 군대 무늬 장애물이 널려있으며 내구도가 최대 5인 단단한 상자도 나온다. 이 나무 상자를 부수면 높은 확률로 물풍선을 펑펑 쏴대는 탱크를 얻을 수 있다.');
INSERT INTO gameMap VALUES ('크레이지아케이드', '팩토리', '각종 물풍선을 만드는 공장. 붐힐의 동쪽에 있는 곳이다. 공장답게 블럭 일부가 박스 모양이며 트랩, 산소통 아이템이 뜬다.최초로 특수 아이템이 등장한 맵이다.');

SELECT * 
FROM gameInfo AS A
JOIN gameCenterInfo AS B
JOIN gameCharacter AS C
JOIN gameMap AS D
ON A.gameName = B.gameName AND A.gameName = C.gameName AND A.gameName = D.gameName;

SELECT * FROM user;
SELECT * FROM gameCenterInfo;
SELECT * FROM gameInfo;
SELECT * FROM gameCharacter;
SELECT * FROM gameMap;
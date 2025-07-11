# Todo List

Spring Boot와 MySQL, JPA 기반으로 한 개인 할 일 관리 시스템입니다.
처음으로 작업해보는 백엔드 프로젝트이기에 RESTful API 설계 바탕으로 CRUD 기능과 JWT 인증 및 인가, 필터/정렬 기능까지 포함하여, 백엔드의 전반적인 흐름을 학습하고자 제작한 프로젝트입니다.

## 기술 스택
Language : Java 17
Frontend : JavaScript, HTML, CSS
Framework: Spring Boot(Version 3.4.5)
Database : Mysql
Build Tool : Gradle
Security : Spring Security 기반 JWT
ORM : Spring Data JPA
IDE : IntelliJ IDEA
API 테스트 : Postman

## 주요 기능 구현 현황

## ✅ 할 일 기능
 - 할 일 추가, 할 일 조회, 할 일 수정, 할 일 삭제

## ✅ 사용자 인증 및 인가(JWT)
 - JWT 발급 및 인증 필터 적용
 - 로그인된 사용자만 할 일 CRUD API 사용 가능
 - Spring Security 기반 JWT 구성

## 필터 및 정렬 기능
 - '가나다', 'abc', 작성 id 순서대로 정렬

## 개발 포인트
- 게층 분리를 통해 **확장 가능한 구조 설계**학습
- JWT 기반 인증/인가 구현을 통해 **보안 로직 처리 경험**
- 필터 및 정렬 로직을 통해 **API 유연성 확보**
- 데이터베이스 연동 및 쿼리 테스트를 통해 **MySQL 기반 실습 경험** 축적
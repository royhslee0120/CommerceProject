```
src
└─ main
   ├── java
   │   └── com
   │       └── paymentteamproject
   │           ├── PaymentTeamProjectApplication.java
   │           ├── common
   │           │   ├── controller          ← HomeController, PageController, ConfigController
   │           │   ├── dto                 ← ApiResponse, PublicConfigResponse
   │           │   └── entity              ← BaseEntity (createdAt, updatedAt)
   │           ├── config
   │           │   ├── SecurityConfig.java
   │           │   ├── RestClientConfig.java
   │           │   ├── PortOneProperties.java
   │           │   ├── AppProperties.java
   │           │   ├── ClientApiProperties.java
   │           │   └── GlobalExceptionHandler.java
   │           ├── security
   │           │   ├── JwtTokenProvider.java
   │           │   ├── JwtAuthenticationFilter.java
   │           │   ├── JwtAuthenticationEntryPoint.java
   │           │   ├── CustomUserDetails.java
   │           │   └── CustomUserDetailsService.java
   │           └── domain
   │               ├── auth                ← 인증 (JWT, Refresh Token)
   │               ├── user                ← 사용자 (포인트, 총 거래액)
   │               ├── product             ← 상품 (재고 관리)
   │               ├── order               ← 주문 (주문번호 자동생성)
   │               ├── orderProduct        ← 주문-상품 매핑
   │               ├── payment             ← 결제 (Append-Only, 이벤트 발행)
   │               ├── refund              ← 환불 (Append-Only)
   │               ├── subscription        ← 구독 신청/조회/해지
   │               ├── billing             ← 빌링키 결제/청구 내역
   │               ├── plan                ← 구독 플랜
   │               ├── paymentMethod       ← 결제 수단
   │               ├── pointTransaction    ← 포인트 적립/사용/만료
   │               ├── membershipTransaction ← 멤버십 등급 이력 + 스케줄러
   │               └── webhook             ← PortOne 웹훅 수신 및 검증
   │
   └── resources
       ├── application.yml
       ├── application-local.yml
       ├── application-prod.yml
       ├── client-api-config.yml
       └── templates                       ← Thymeleaf 템플릿

```

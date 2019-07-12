# SpringBoot 이해하기.

## SpringBoot 프로젝트 생성하기.

## SpringBoot VisualStudio Code 로 시작하기.

아래 스프링 부트 VSCode 용 확장팩을 설치합니다.

[Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=Pivotal.vscode-boot-dev-pack)

## 기타 알아두면 좋은 확장팩

## 02.Filter 등록하기.

Filter 는 스프링 프레임워크에서 요청이 가장 먼저 통과합니다.

필터는 체이닝이 되어 잇어, 필터 순서에 따라서 처리가 됩니다. Order 에 의해서 설정된 값으로 순서가 결정이 됩니다.

요청 --> A 필터 --> B 필터 --> 이후처리 --> 응답 --> B 필터 --> A 필터 순으로 처리됩니다.

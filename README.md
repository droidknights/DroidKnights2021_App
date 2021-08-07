# 🚧🚧🚧 👩‍💻👨‍💻 DroidKnights2021 App 👨‍💻👩‍💻 🚧🚧🚧

드로이드나이츠는 기술 세션으로 개발자들의 경험을 공유하는 안드로이드 컨퍼런스 입니다. 

## Guide

### Contributions Welcome!

드로이드나이츠 행사 정보를 볼 수 있는 앱을 개발하고 있습니다. 여러분들의 참여로 함께 만들어 나가길 기대합니다!

자세한 내용은 [CONTRIBUTING.md](CONTRIBUTING.md) 를 참고해주세요.

## Development

#### Required

- IDE : Android Studio Arctic Fox
- JDK : Java 11을 실행할 수 있는 JDK
  - (권장) Android Studio 설치시 Embeded된 JDK (Open JDK)
  - Java 11을 사용하는 JDK (Open JDK, AdoptOpenJDK, GraalVM)
- Kotlin Language : 1.5.10

#### Laguage

- Kotlin

#### Libraries

- AndroidX
  - Activity & Activity Compose
  - AppCompat
  - Core
  - ConstraintLayout
  - Fragment
  - Lifecycle & ViewModel Compose
  - Navigation
  - RecyclerView
- Google Android Material
- Kotlin Libraries (Coroutine, DateTime, Serialization)
- Compose (1.0.0 or higher)
- Coil & Coil-compose
- Dagger & Hilt
- Accompanist (FlowLayout, Pager)
- Square (Retrofit, OkHttp)
- Timber

### Architecture

#### Layer

본 프로젝트는 Layered Architecture 형태로 설계되어 있습니다. 현재 Presentation/Domain/Data 레이어 구조를 띄고 있습니다.

<img src="arts/architecture-layer.png" width="480" />

#### Module

본 프로젝트는 Multi-module 구조이며 각 Feature마다 모듈 형태로 구성되어 있습니다.

<img src="arts/architecture-module.png" />

## Thanks

참여해주신 모든 분들 감사합니다!

- GitHub : [Contributors](https://github.com/droidknights/DroidKnights2021_App/graphs/contributors)
- Designer : Nayeon Kim

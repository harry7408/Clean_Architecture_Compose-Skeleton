# Clean Architecture

## Why?
#### 개발, 배포, 유지 보수 등을 용이하게 하기 위해 사용

⭐ 개발에 투입되는 비용을 최소화 하기 위함 (물적자원, 인적자원 등등)

### 저수준 모듈과 고수준 모듈
- 저수준 모듈 : 상세한 기능 구현된 모듈 및 잦은 변경이 있을만한 요소들의 집합
- 고수준 모듈 : 핵심적인 비즈니스 로직 -> 추상적으로 서술

💡 Clean Architecture는 저수준 모듈과 고수준 모듈로 코드를 분리하는 것으로 부터 시작한다  

## SOLID 원칙
1. 단일 책임 법칙 (Single Responsibility Principle)

    - 하나의 Class는 하나의 책임만 진다 
   
      (모듈의 결합도는 낮추고 응집도를 높이기 위함)

   
2. 개방 폐쇄 원칙 (Open-Closed Principle)
   
    - 기존의 코드를 변경하지 않고 기능울 추가할 수 있도록 설계해야한다
    - 의존성 역전 원칙의 설계 기반이 된다 

       (추상화를 통해 OCP를 지킬 수 있다 : abstract, interface 사용)


3. 리스코프 치환 원칙 (Liskov Substitution Principle)

   - 자식 클래스는 부모 클래스로 대체 가능해야 한다

     (Polymorphism을 의미한다)


4. 인터페이스 분리 원칙 (Interface Segregation Principle)
    
    - 목적과 용도에 적합한 인터페이스만을 제공한다


5. ⭐의존성 역전 원칙 (Dependency Inversion Principle)

    - 세부적인 내용을 갖고 있지 않은 추상화된 상위 수준에 의존해야 한다

      (구현체가 아닌 추상화된 요소를 참조 : 의존성 주입을 위한 기반 작업)
   

### Clean Architecture
![Image](https://github.com/user-attachments/assets/e87ae463-695b-4a99-9c4f-2e369bcf63b8)

- 노란색 동심원 : Business Logic 및 Company's Context (고수준 모듈)

   - 규칙, 행동, 핵심 로직 등 변경이 되지 않을 만한 내용들이 들어가야 한다
  
   ex) 데이터 모델, 객체, 함수의 집합 etc..


- 빨간색 동심원 : Application이 갖는 기능
   
   - 노란색 동심원에서 정의한 기능, 로직 등을 단일 책임 원칙(SRP)를 준수하고 캡슐화 하여 구현한 객체들이 정의 (Interface 및 abstract Class)
   - 1개의 UseCase는 1개의 기능만을 담당하도록 구현


- 초록색 동심원 : 계층에서 가장 편리한 방식으로 변환

   - UseCase에서 추상화된 Interface, Abstract Class의 상세 구현을 주로 수행
  
   ⭐각 계층에서 가장 이해하기 쉬운 Type으로 변환 (toDomain, toModel 등등 Mapping 기능 구현)


- 파란색 동심원 : 안드로이드 프레임워크

   - Android SDK, Activity, Fragment 등등 세부적인 내용들이 위치한 영역

⭐ **의존성 방향은 반드시 바깥쪽 동심원에서 안쪽 동심원을 향해야한다**

⭐ **동심원이 꼭 4개일 필요는 없으나 본질은 같다 (바깥쪽으로 갈수록 세부 구현사항이 많아진다)**

### 각 계층간 횡단 방법
- 인터페이스 분리 원칙과 의존성 역전 원칙을 활용하여 Interface 및 Abstract로 추상화 한 내용을 주입받고 바깥쪽 동심원에서 구현체는 바깥쪽 동심원에서 세부 내용을 구현
- 각 Layer에서 정의한 Data 형식에 따라 잘 Mapping 해줘야 한다 (Extension Function or Mapping Function 구현)

---
# Clean Architecture (In Android)

## Android Developer's Guide Architecture

### 관심사 분리를 위한 2~3개의 Layer로 나누기
![Image](https://github.com/user-attachments/assets/9c8b1e1a-bf22-46ac-bc12-adf2901db1bc)
- UI Layer : Data를 화면에 표시
- Domain Layer (Optional) : 비즈니스 로직 및 Context
- Data Layer : Local Device, Network API 등 데이터를 가져옴

=> 구글 권장 아키텍쳐는 Domain Layer가 Data Layer를 참조하고 Domain Layer를 정의하지 않으면 UI Layer가 Data Layer를 직접 참조 한다

## Clean Architecture

### 관심사를 보통 3개의 Layer로 분리 (Data, Domain, Presentation)
- Presentation Layer : Data를 화면에 표시
- Domain Layer : 비즈니스 로직 및 Context
- Data Layer : Local Device, Network API 등 데이터를 가져옴

=> Clean Architecture에서는 의존성 방향이 반드시 바깥쪽에서 안쪽으로 향해야 하기 때문에 UI에서 Data를 직접 참조할 수 없다

## Android 프로젝트에서 CleanArchitecture 적용

### Data, Domain, Presentation, App 모듈로 분리
![Image](https://github.com/user-attachments/assets/475247d9-2797-43c6-b9e3-3b58a831a7ba)

- Clean Architecture의 의존성 방향에 유의하여 모듈 분리 및 의존관계 설정
- Domain Layer는 아무 영역도 참조하지 않는다 (Java, Kotlin 라이브러리로 제작 권장)
- Presentation, Data Layer는 Domain Layer만을 참조한다

⭐ 각 모듈간 연결은 의존성 역전 법칙(DIP)에 따라 객체를 주입받아 활용

⭐ **이 방식은 Standard한 방식으로 필요에 따라 모듈을 더 나눠도 상관 없다**

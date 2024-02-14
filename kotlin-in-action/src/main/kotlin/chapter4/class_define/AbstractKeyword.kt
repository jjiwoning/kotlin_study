package chapter4.class_define

// 추상 클래스 -> 기본으로 open, 해당 클래스의 인스턴스 생성 불가
abstract class Animated {

    abstract fun animate() // 추상 메서드 -> open이고 하위 클래스는 이 메서드를 반드시 오버리이드 해야 된다.

}

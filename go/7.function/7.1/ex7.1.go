package main

import "fmt"

func Add(a int, b int) int { // 매개변수 생성 및 초기화
	return a + b
	// 로컬 변수 삭제
}

func main() {
	c := Add(1, 2)

	fmt.Println(c)
}

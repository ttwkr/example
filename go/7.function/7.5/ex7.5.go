// 7.3, 7.4 뛰어 넘고 (아는내용)
// 리턴할 내용 변수지정
// 리턴 변수를 지정할때는 전부다 지정해서 하거나 아예 변수명을 지정하지 않거나 해야한다

package main

import "fmt"

func Divide(a, b int) (result int, is_success bool) {
	if b == 0 {
		result = 0
		is_success = false
		return
	}
	result = a / b
	is_success = true
	return
}

func main() {
	c, is_success := Divide(9, 3)
	fmt.Println(c, is_success)
	d, is_success := Divide(9, 0)
	fmt.Println(d, is_success)
}

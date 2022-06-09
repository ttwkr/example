// 아주 작은 오차를 판별하는 방법1
package main

import "fmt"

const epsilon = 0.000001

func equal(a, b float64) bool {
	if a > b {
		if a-b <= epsilon {
			return true
		} else {
			return false
		}
	} else {
		if b-a <= epsilon {
			return true
		} else {
			return false
		}
	}
}

func main() {
	var a float64 = 0.1
	var b float64 = 0.2
	var c float64 = 0.3
	var d float64 = 0.4

	fmt.Printf("%0.18f + %0.18f = %0.18f\n", a, b, a+b)
	fmt.Printf("%0.18f == %0.18f : %v\n", c, a+b, equal(a+b, c))

	a = 0.000000000004
	b = 0.000000000002
	c = 0.000000000007
	d = 0.000000000008

	fmt.Printf("%g == %g : %v\n", c, a+b, equal(a+b, c))
}
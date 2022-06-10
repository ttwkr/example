package main

import "fmt"

func main() {
	for i := 1; i < 10; i++ {
		if i == 3 || i == 4 || i == 5 || i == 6 {
			continue
		}
		for j := 1; j < 10; j++ {
			fmt.Printf("%d * %d = %d\n", i, j, i*j)
		}
	}
}

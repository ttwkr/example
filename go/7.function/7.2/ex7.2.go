package main

import "fmt"

func Average(name string, math int, eng int, history int) {
	average := (math + eng + history) / 3
	fmt.Printf("%s Average Score : %d\n", name, average)
}

func main() {
	Average("Seo Sang JIn", 80, 74, 95)
	Average("My Sister", 88, 92, 53)
	Average("My Brother", 78, 73, 73)
}

package main

import (
	"fmt"
	"github.com/joho/godotenv"
	"os"
)

func main(){
	err := godotenv.Load(".env")
	if err != nil {
		fmt.Println("error")
	}

	url := os.Getenv("URL")
	fmt.Println(url)
}

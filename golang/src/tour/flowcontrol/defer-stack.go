package main

import "fmt"

func main() {
  fmt.Println("Let's count backwards!")

  for i:= 0; i < 10; i++ {
    defer fmt.Println(i)
  }

  fmt.Println("Done.")

}

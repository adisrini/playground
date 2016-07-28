package main

import (
  "fmt"
)

func main() {
  defer fmt.Println("Done!")
  for i := 0; i < 10; i++ {
    fmt.Println(i)
  }
}

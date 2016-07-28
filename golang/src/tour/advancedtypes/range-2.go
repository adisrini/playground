package main

import "fmt"

func main() {
  pow := make([]int, 30)
  for i := range pow {
    pow[i] = 1 << uint(i)
  }
  for _, value := range pow {
    fmt.Printf("%d\n", value)
  }
}

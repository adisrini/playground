package main

import "fmt"

func split(sum int) (x, y int) {
  x = sum/2
  y = sum - x
  return          // this is a naked return. it returns x and y implicitly. pretty cool.
}

func main() {
  fmt.Println(split(20))
}

package main

import (
  "fmt"
  "time"
  "math/rand"
)

func main()  {
  rand.Seed(time.Now().UTC().UnixNano())
  fmt.Println("This is a random number:", rand.Intn(100))
}

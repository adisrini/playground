package main

import (
  "fmt"
  "time"
  "github.com/tj/go-spin"
)

func main() {
  s := spin.New()
  s.Set(spin.Default);

  sum := float64(1)

  for i := 0; i < 60; i++ {
    fmt.Printf("\r  \033[36mcomputing\033[m %s ", s.Next())
    time.Sleep(100 * time.Millisecond)
    sum += sum
  }

  fmt.Println(sum)

}

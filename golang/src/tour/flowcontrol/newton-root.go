package main

import (
	"fmt"
	"math"
)

func Sqrt1(x float64) float64 {
	z := float64(1)
	for i := 0; i < 10; i++ {
		z -= ((z*z - x)/(2*z))
	}
	return z
}

func Sqrt2(x float64) (float64, int) {
	z := float64(1)
	delta := float64(0.0000000000001)
	iter := 0
	for {
		next := z - ((z*z - x)/(2*z))
		if math.Abs(next - z) < delta {
			break
		}
		z = next
		iter += 1
	}
	return z, iter
}

func accuracy(x, y float64) float64 {
	return 1 - (y - x)/y
}

func main() {
	fmt.Println(accuracy(Sqrt1(1), math.Sqrt(1)))
	fmt.Println(accuracy(Sqrt1(2), math.Sqrt(2)))
	fmt.Println(accuracy(Sqrt1(3), math.Sqrt(3)))
	fmt.Println(accuracy(Sqrt1(4), math.Sqrt(4)))
	fmt.Println(accuracy(Sqrt1(7), math.Sqrt(7)))

	sqrt1, iter1 := Sqrt2(1)
	fmt.Println(accuracy(sqrt1, math.Sqrt(1)), iter1)
	sqrt2, iter2 := Sqrt2(2)
	fmt.Println(accuracy(sqrt2, math.Sqrt(2)), iter2)
	sqrt3, iter3 := Sqrt2(3)
	fmt.Println(accuracy(sqrt3, math.Sqrt(3)), iter3)
}

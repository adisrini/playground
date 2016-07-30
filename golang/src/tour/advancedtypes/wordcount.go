package main

import (
	"strings"

	"golang.org/x/tour/wc"
)

func WordCount(s string) map[string]int {
	split := strings.Fields(s)
	var counts = make(map[string]int)
	for i := range split {
		if _, ok := counts[split[i]]; ok {
			counts[split[i]] += 1
		} else {
			counts[split[i]] = 1
		}
	}
	return counts
}

func main() {
	wc.Test(WordCount)
}

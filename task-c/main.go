package main

import (
	"context"
	"fmt"
	"golang.org/x/sync/semaphore"
	"math/rand"
	"time"
)

type Components [3]bool

var ctx = context.Background()
var sem = semaphore.NewWeighted(1)
var components *Components = nil

func smoker(t int) {
	for {
		err := sem.Acquire(ctx, 1)
		if err != nil {
			return
		}

		if components != nil {
			if !components[t] {
				println(t + 1)
				time.Sleep(3 * time.Second)
				components = nil
			}
		}

		sem.Release(1)
	}
}

func main() {
	for i := 0; i < 3; i += 1 {
		go smoker(i)
	}

	for {
		err := sem.Acquire(ctx, 1)
		if err != nil {
			return
		}

		if components == nil {
			f := rand.Intn(3)
			components = &Components{f != 0, f != 1, f != 2}
			fmt.Println(components)
		}

		sem.Release(1)
	}
}

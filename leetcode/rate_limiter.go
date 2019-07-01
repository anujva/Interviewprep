package main

import (
	"fmt"
	"sync"
	"time"
)

type RateLimiter struct {
	limit   int
	c       chan int
	running bool
}

func New(rate int) *RateLimiter {
	return &RateLimiter{
		limit:   rate,
		c:       make(chan int, rate),
		running: false,
	}
}

func (r *RateLimiter) Limit() {
	for range r.c {
		return
	}
}

func (r *RateLimiter) Close() {
	r.running = false
}

func (r *RateLimiter) Start() {
	go func(r *RateLimiter) {
		r.running = true
		for r.running {
			for i := 0; i < r.limit; i++ {
				r.c <- i
			}
			time.Sleep(time.Second)
		}
		close(r.c)
		fmt.Println("Channel closed")
	}(r)
}

func main() {
	r := New(100)
	r.Start()
	w := sync.WaitGroup{}
	w.Add(3)
	go func() {
		for i := 0; i < 1000; i++ {
			r.Limit()
			fmt.Printf("%d, ", i)
		}
		w.Done()
	}()
	go func() {
		for i := 1000; i < 2000; i++ {
			r.Limit()
			fmt.Printf("%d, ", i)
		}
		w.Done()
	}()
	go func() {
		for i := 2000; i < 3000; i++ {
			r.Limit()
			fmt.Printf("%d, ", i)
	`	}
		r.Close()
		w.Done()
	}()
	w.Wait()
}

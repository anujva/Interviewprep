package main

import (
	"fmt"
	"math"
)

func RoundPrices(A []float64) []int {
	roundedSumVal := roundedSum(A)
	fmt.Println(roundedSumVal)
	MinRoundPricesMatrix = make([][]int, roundedSumVal+1)
	for i := 0; i < roundedSumVal+1; i++ {
		MinRoundPricesMatrix[i] = make([]int, len(A))
	}

	MinRoundPricesMatrix[0][0] = 0
	MinRoundPricesMatrix[1][0] = 1

	for i := 1; i < len(A); i++ {
		// What is the current rounded sum right now?
		T := roundedSum(A[0 : i+1])
		MinRoundPricesMatrix[T][i] = MinimumOf(MinRoundPricesMatrix[T-math.Floor(A[i])][i-1], MinRoundPricesMatrix[T-math.Ceil(A[i])][i-1])
	}

	return []int{}
}

func roundedSum(A []float64) int {
	sum := 0.0
	for _, v := range A {
		sum = sum + v
	}

	if sum-math.Floor(sum) < 0.5 {
		return int(math.Floor(sum))
	}
	return int(math.Floor(sum)) + 1
}

func main() {
	fmt.Println(RoundPrices([]float64{0.70, 2.80, 4.90}))
}

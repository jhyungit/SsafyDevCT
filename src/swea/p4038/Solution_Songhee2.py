import sys

sys.stdin = open("./sample_input.txt", "r")

T = int(input())

for test in range(1, T+1):
    book = input()
    word = input()
    count = 0

    for i in range(len(book) - len(word) + 1):
        if(book[i:i+len(word)] == word):
            count += 1

    print(f'#{test} {count}')

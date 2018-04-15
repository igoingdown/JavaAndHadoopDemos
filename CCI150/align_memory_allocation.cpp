#include <cstdio>
#include <iostream>

using namespace std;

void* aligned_allocation(unsigned required, unsigned alignment);
void aligned_free(void *p2);


int main() {
	int *p1 = (int*) aligned_allocation(2, 16);
	aligned_free(p1);
	return 0;
}

void* aligned_allocation(unsigned required, unsigned alignment) {
	void *p1, **p2;
	unsigned offset = alignment - 1 + sizeof(void *);
	if ((p1 = (void*)malloc(required + offset)) == NULL) return NULL;
	p2 = (void**) (((unsigned long long)(p1) + offset) & ~(alignment - 1));
	// [p1, p1 + alignment - 1]中一定有一个可以被alignment整除。
	p2[-1] = p1;
	return p2;
}

void aligned_free(void *p2) {
	void *p1 = ((void**) p2)[-1];
	free(p1);
}
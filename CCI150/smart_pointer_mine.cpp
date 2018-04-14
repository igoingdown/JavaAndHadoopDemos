#include <iostream>

using namespace std;

template <class T> class my_smart_pointer {
	public:
		my_smart_pointer(T *o) {
			ref_count = new unsigned(1);
			ref = o;
		}

		my_smart_pointer(my_smart_pointer<T> &p) {
			ref = p.ref;
			ref_count = p.ref_count;
			++(*ref_count);
		}
		T get_value() {
			return *ref;
		}

		unsigned get_count() {
			return *ref_count;
		}

		my_smart_pointer & operator = (my_smart_pointer<T> &p) {  // 赋值运算符重载返回类型必须是引用类型，这样才能实现连续赋值
			if (p == this) return *this;
			if (*ref_count > 0) remove();  // 赋值之后，智能指针指向了新的对象，指向原来的对象的指针减少了，新对象的引用增加了，所以要分两步
			ref = p.ref;
			ref_count = p.ref_count;
			++(*ref_count);
			return *this;
		}

		~my_smart_pointer() {
			remove();
		}
	protected:
		void remove() {
			--(*ref_count);
			if (ref_count == 0) {
				delete ref;
				delete ref_count;
			}
			ref = NULL;
			ref_count = NULL;
		}

	private:
		T *ref;
		unsigned *ref_count;
};



int main() {
	float *fptr = new float(2.10);
	my_smart_pointer<float> sptr(fptr);
	my_smart_pointer<float> sptr2(sptr);
	cout << sptr2.get_count() << endl;
	return 0;
}

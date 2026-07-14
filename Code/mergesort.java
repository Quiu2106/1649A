public class mergesort {
	// Merge Sort chia mảng làm đôi, sắp xếp từng phần rồi gộp lại theo thứ tự tăng dần.
	public static void sort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return; // Không cần sắp xếp nếu mảng quá nhỏ
		}
		mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
	}

	private static void mergeSort(int[] arr, int left, int right, int[] temp) {
		if (left >= right) {
			return;
		}

		int mid = left + (right - left) / 2;
		mergeSort(arr, left, mid, temp);      // Sắp xếp nửa trái
		mergeSort(arr, mid + 1, right, temp); // Sắp xếp nửa phải
		merge(arr, left, mid, right, temp);   // Gộp hai nửa đã sắp xếp
	}

	private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;     // Chỉ số duyệt nửa trái
		int j = mid + 1;  // Chỉ số duyệt nửa phải
		int k = left;     // Chỉ số ghi vào mảng tạm

		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= right) {
			temp[k++] = arr[j++];
		}

		// Sao chép kết quả tạm về mảng chính
		for (int idx = left; idx <= right; idx++) {
			arr[idx] = temp[idx];
		}
	}

	// Hàm minh họa cách dùng Merge Sort
	public static void main(String[] args) {
		int[] data = {8, 3, 1, 7, 0, 10, 2};
		System.out.print("Mảng gốc: ");
		printArray(data);

		sort(data);

		System.out.print("Mảng sau khi sắp xếp: ");
		printArray(data);
	}

	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}

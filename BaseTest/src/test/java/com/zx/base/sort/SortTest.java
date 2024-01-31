package com.zx.base.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @program: myStudy
 * @description: Java排序算法
 * @author: zhou  xun
 * @create: 2023-11-02 10:44
 */
public class SortTest {
    @Test
    @DisplayName("冒泡排序")
    public void bubbleSort() {
        int[] arr = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换arr[j]和arr[j+1]:
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    @Test
    @DisplayName("插入排序")
    public void InsertionSort() {
        int[] arr = {28, 12, 89, 73, 65, 18, 96, 50, 8, 36};
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    @Test
    @DisplayName("快速排序")
    public void QuickSort() {
        int[] array = {6, 72, 113, 11, 23};
        quickSort(array, 0, array.length - 1);
    }

    //参考 https://zhuanlan.zhihu.com/p/373348669
//一、快速排序的复杂性
//
//1、时间复杂度
//
//    最坏的情况复杂度[Big-O] ： 当选择的中心元素是最大或最小的元素时发生，这种情况导致中心元素位于已排序数组的最末端，一个子数组始终为空，而另一个子数组包含元素，因此，仅在此子数组上调用quicksort，快速排序算法对于分散的数据具有更好的性能。
//    最好的情况复杂度[Big-O] ： 当中心元素始终是中间元素或靠近中间元素时，会发生这种情况。
//    平均复杂度[Big-O] ： 在不出现上述条件时发生。
//    2、空间复杂度
//    快速排序的空间复杂度为O(log n)。
//
//二、快速排序的应用
//
//在以下情况下使用Quicksort算法
//
//    编程语言适合递归
//    时间复杂度很重要
//    空间复杂性很重要
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 获取划分子数组的位置
            int position = partition(array, low, high);
            // 左子数组递归调用
            quickSort(array, low, position - 1);
            // 右子数组递归调用
            quickSort(array, position + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        // 取最后一个元素作为中心元素
        int pivot = array[high];
        // 定义指向比中心元素大的指针，首先指向第一个元素
        int pointer = low;
        // 遍历数组中的所有元素，将比中心元素大的放在右边，比中心元素小的放在左边
        for (int i = low; i < high; i++) {
            if (array[i] <= pivot) {
                // 将比中心元素小的元素和指针指向的元素交换位置
                // 如果第一个元素比中心元素小，这里就是自己和自己交换位置，指针和索引都向下一位移动
                // 如果元素比中心元素大，索引向下移动，指针指向这个较大的元素，直到找到比中心元素小的元素，并交换位置，指针向下移动
                int temp = array[i];
                array[i] = array[pointer];
                array[pointer] = temp;
                pointer++;
            }
            System.out.println(Arrays.toString(array));
        }
        // 将中心元素和指针指向的元素交换位置
        int temp = array[pointer];
        array[pointer] = array[high];
        array[high] = temp;
        return pointer;
    }
}

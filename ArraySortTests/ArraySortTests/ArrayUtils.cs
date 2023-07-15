using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ArraySortTests
{
    /**
     * Утилиты для работы с массивом
     */
    public class ArrayUtils
    {

        public static Random random = new Random();

        /**
         * Подготовить массив случайных чисел
         * @return
         */
        public static int[] prepareArray()
        {
            return prepareArray(random.Next(10, 16));
        }

        /**
         * Подготовить массив случайных чисел
         * @param length
         * @return
         */
        public static int[] prepareArray(int length)
        {
            int[] array = new int[length];
            for (int i = 0; i < array.Length; i++)
            {
                array[i] = random.Next(-99, 100);
            }
            return array;
        }

    }
}

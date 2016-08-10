package fanglab.framework.threading;

import java.util.*;
import java.util.concurrent.*;

import fanglab.framework.*;

/**
 * ���д���
 *
 */
public class SlParallel {
	/**
	 * ���д���
	 * 
	 * @param items
	 *            ��Ԫ��
	 * @param maxDegreeOfParallelism
	 *            �����ж�
	 * @param func
	 *            ����Ϊ
	 */
	public static <T> void forEach(Iterable<T> items,
			int maxDegreeOfParallelism, final ISlActionWithTFunc<T> func) {
		ExecutorService executorService = Executors
				.newFixedThreadPool(maxDegreeOfParallelism);
		List<Future<?>> futures = new LinkedList<Future<?>>();

		for (final T item : items) {
			Future<?> future = executorService.submit(new Runnable() {

				@Override
				public void run() {
					func.invoke(item);
				}
			});

			futures.add(future);
		}

		for (Future<?> future : futures) {
			try {
				future.get();
			} catch (Exception err) {
				throw new RuntimeException(err);
			}
		}

		executorService.shutdown();
	}

	/**
	 * ���д���
	 * 
	 * @param start
	 *            ����ʼ
	 * @param stop
	 *            ������
	 * @param func
	 *            ����Ϊ
	 */
	public static void forLoop(int start, int stop,
			final ISlActionWithTFunc<Integer> func) {
		ExecutorService executorService = Executors.newFixedThreadPool(stop);
		List<Future<?>> futures = new LinkedList<Future<?>>();

		for (int i = start; i < stop; i++) {

			final int temp = i;
			Future<?> future = executorService.submit(new Runnable() {

				@Override
				public void run() {
					func.invoke(temp);
				}
			});

			futures.add(future);
		}

		for (Future<?> future : futures) {
			try {
				future.get();
			} catch (Exception err) {
				throw new RuntimeException(err);
			}
		}

		executorService.shutdown();
	}
}

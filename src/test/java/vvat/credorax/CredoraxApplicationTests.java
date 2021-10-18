package vvat.credorax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vvat.credorax.dal.Storage;
import vvat.credorax.data.fields.*;
import vvat.credorax.data.struct.Card;
import vvat.credorax.data.struct.Cardholder;
import vvat.credorax.data.struct.Invoice;

import java.util.concurrent.*;

@SpringBootTest
class CredoraxApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testStorage(@Autowired Storage storage) {
		storage.storeStruct(getInvoice(1));
		Invoice invoice = storage.retrieveStruct(1);
		Assertions.assertEquals("1234567887654321", invoice.getCard().getPan().getValue());
	}

	private Invoice getInvoice(int invoiceNumber) {
		return new Invoice(
				new InvoiceNumber(invoiceNumber),
				new Amount(1.2),
				new Currency("UAH"),
				new Cardholder(
						new Name("I me"),
						new Email("virtualvat@gmail.com")
				),
				new Card(
						new Pan("1234567887654321"),
						new Expiry("1234"),
						new Cvv(951)
				)
		);
	}

	private static final int STORAGE_TASKS_NUM = 10000;

	@Test
	void testStorageLoad(@Autowired Storage storage) {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		Future<?>[] futures = new Future<?>[STORAGE_TASKS_NUM];
		Invoice[] invoices = new Invoice[STORAGE_TASKS_NUM];

		CountDownLatch l1 = new CountDownLatch(1);
		for (int i = 0; i < STORAGE_TASKS_NUM; i++) {
			Invoice invoice = getInvoice(i);
			invoices[i] = invoice;
			//Integer ii = i;
			futures[i] = threadPool.submit(() -> {
				//System.out.print("ba" + ii);
				try {
					l1.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
					Assertions.fail();
				}
				//System.out.print("aa" + ii);
				storage.storeStruct(invoice);
			});
		}
		l1.countDown();
		//System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		for (Future<?> future: futures) {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
				Assertions.fail();
			}
		}

		CountDownLatch l2 = new CountDownLatch(1);
		for (int i = 0; i < STORAGE_TASKS_NUM; i++) {
			Invoice invoice = invoices[i];
			Integer invoiceNumber = i;
			futures[i] = threadPool.submit(() -> {
				try {
					l2.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
					Assertions.fail();
				}
				Assertions.assertEquals(invoice.getInvoiceNumber().getValue(),
						storage.retrieveStruct(invoiceNumber).getInvoiceNumber().getValue());
			});
		}
		l2.countDown();
		for (Future<?> future: futures) {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
				Assertions.fail();
			}
		}

		// Add also mixed read/write simultaneous operations
	}

	// Add other Spring services related tests for e.g. Audit
}

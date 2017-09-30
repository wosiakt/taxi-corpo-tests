import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 */
public class TaxiCorpoTest {


    @Test
    public void shouldReturnTaxiIdWhenAnyIsAvailable() {
        //given
        TaxiCorpo corpo = createCorpoWithTaxiAvailable();
        //when
        String returnedTaxiId = corpo.reserveAvailableTaxi(0, 0);
        //then
        assertThat(returnedTaxiId).isNotNull();
        assertThat(returnedTaxiId).isNotBlank();
    }

    private TaxiCorpo createCorpoWithTaxiAvailable() {
        TaxiCar taxi = new TaxiCar("id1", 0, 0);
        TaxiCar[] taxiTable = {taxi};
        return new TaxiCorpo(taxiTable);
    }

    @Test
    public void shouldReturnNullIfThereIsNoAvailableTaxi() {
        //given
        TaxiCorpo corpo = createCorpoWithoutAvailableTaxi();
        //when
        String taxiId = corpo.reserveAvailableTaxi(0, 0);
        //ther
        assertThat(taxiId).isNull();
    }

    private TaxiCorpo createCorpoWithoutAvailableTaxi() {

        TaxiCar mockTaxi = mock(TaxiCar.class);
        when(mockTaxi.isAvailable()).thenReturn(false);

        TaxiCar[] taxiTable = {mockTaxi};
        return new TaxiCorpo(taxiTable);
    }


}
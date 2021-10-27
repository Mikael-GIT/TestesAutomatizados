
import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;
import br.com.alura.tdd.service.ReajusteService;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario func;

    @Before
    public void inicializar() {
        this.service = new ReajusteService();
        this.func = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        service.calcularReajuste(func, Desempenho.A_DESEJAR);

        Assert.assertEquals(new BigDecimal("1030.00"), func.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        service.calcularReajuste(func, Desempenho.BOM);

        Assert.assertEquals(new BigDecimal("1150.00"), func.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        service.calcularReajuste(func, Desempenho.OTIMO);

        Assert.assertEquals(new BigDecimal("1200.00"), func.getSalario());
    }
}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.service.BonusService;

public class BonusServiceTest {

    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
        // try {
        // service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new
        // BigDecimal("4000")));
        // Se ele passar dessa linhaa, tem que chamar o metodo fail do junit
        // fail();
        // } catch (Exception e) {
        // assertEquals("Funcionário com salário maior do que mil reais não pode receber
        // bônus.", e.getMessage());
        // }
    }

    @Test
    public void bonusDeveriaSerDezPorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

        Assert.assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    public void bonusDeveriaSerDezPorcentoParaSalarioDeExatamenteDezMilReais() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

        Assert.assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
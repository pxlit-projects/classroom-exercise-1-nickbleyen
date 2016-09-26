package be.pxl.ioc;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BaristaTest {


    @Test
    public void serve_GivenABaristaWithACustomerFriendlyWorkEthic_CustomerIsSatisfied_AndGotProperName() throws Exception {
        String customer = "meliodas";
        CustomerExperience customerExperience = new Barista("vicky", new CustomerFriendlyWorkEthic()).serve(customer);

        assertThat(customerExperience.getCustomer()).isEqualTo(customer);
        assertThat(customerExperience.getHappiness()).isEqualTo("satisfied");
        assertThat(customerExperience.gotCorrectNameOnCup()).isTrue();
    }

    @Test
    public void serve_GivenABaristaWithALazyWorkEthic_CustomerIsNotSatisfied_AndDidNotGetProperName() throws Exception {
        String customer = "ban";
        CustomerExperience customerExperience = new Barista("gemma", new LazyWorkEthic()).serve(customer);

        assertThat(customerExperience.getCustomer()).isEqualTo(customer);
        assertThat(customerExperience.getHappiness()).isEqualTo("unsatisfied");
        assertThat(customerExperience.gotCorrectNameOnCup()).isFalse();
    }

    @Test
    public void serve_GivenABaristaWithABadHearingWorkEthic_CustomerIsSatisfied_ButDidNotGetProperName() throws Exception {
        String customer = "elizabeth";
        CustomerExperience customerExperience = new Barista("gianluca", new BadHearingWorkEthic()).serve(customer);

        assertThat(customerExperience.getCustomer()).isEqualTo(customer);
        assertThat(customerExperience.getHappiness()).isEqualTo("satisfied");
        assertThat(customerExperience.gotCorrectNameOnCup()).isFalse();
    }
}
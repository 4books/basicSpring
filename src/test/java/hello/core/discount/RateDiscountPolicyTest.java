package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 필요")
    void vip_o(){

        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //then
        int discount = discountPolicy.discount(member, 10000);

        //when
        assertThat(discount).isEqualTo(1000);

    }

    @Test
    @DisplayName("VIP가 아니면 10% 할인 적용 X")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.BASIC);

        //then
        int discount = discountPolicy.discount(member, 10000);

        //when
        assertThat(discount).isNotEqualTo(1000);
        assertThat(discount).isEqualTo(0);
    }

}
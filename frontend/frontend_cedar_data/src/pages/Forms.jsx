import vacationHoldImg from "../assets/vacationHold.jpg";

export default function Forms() {

    function printForm() {
        return window.print();
    }


    return (
        <div className={"formContainer"}>
            <h2>Forms</h2>
            <img id={"vacationFormImg"} src={vacationHoldImg} alt={"vacation form"}/>
            <input id={"holdMailNameInput"} type={"text"}></input>
            <input id={"holdMailAddressInput"} type={"text"}></input>
            <input id={"holdMailPhoneNumberInput"} type={"text"}></input>
            <input id={"holdMailEmailInput"} type={"text"}></input>
            <input id={"holdMailStartDateInput"} type={"text"}></input>
            <input id={"holdMailEndDateInput"} type={"text"}></input>
            <input id={"holdMailCheckBoxOneInput"} type={"checkbox"}></input>
            <input id={"holdMailCheckBoxTwoInput"} type={"checkbox"}></input>
            <button onClick={printForm}>Print</button>
        </div>
    )
}
import {NavLink, useNavigate} from "react-router-dom";
import {useState} from "react";

export default function Signup() {

    const [inputEin, setInputEin] = useState('');
    const [inputPassword, setInputPassword] = useState('');
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [signupError, setSignupError] = useState("");
    const [signupSuccess, setSignupSuccess] = useState("");

    const navigate = useNavigate();

    function handleEin(event) {
        setInputEin(event.target.value);
        setSignupError("");
    }

    function handlePassword(event) {
        setInputPassword(event.target.value);
        setSignupError("");
    }

    function handleFirstName(event) {
        setFirstName(event.target.value);
        setSignupError("");
    }

    function handleLastName(event) {
        setLastName(event.target.value);
        setSignupError("");
    }

    function handleSignup(event) {
        event.preventDefault();
        const backendUrl = "ec2-3-142-236-250.us-east-2.compute.amazonaws.com";
        const cleanEin = inputEin.trim();

        const getUrl = `${backendUrl}/signup`;

        const signupObj = {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                einNumber: cleanEin,
                firstName: firstName,
                lastName: lastName,
                password: inputPassword
            })
        };

        fetch(getUrl, signupObj)
            .then((response) => {
                if(!response.ok) {
                    throw new Error("EIN in use or Unauthorized EIN");
                }
                return response.json();
            })
            .then(() => {
                setSignupSuccess("Signup successful, redirecting to login.");
                setTimeout(() => {
                    navigate("/login");
                }, 2000);
            })
            .catch((error) => {
                setSignupError(error.message);
                console.error(error);
            })
    }

    return (
        <main>
            <h2>Sign Up</h2>
            <div className={"loginContainer"}>
                <form onSubmit={handleSignup}>
                    <div className={"loginDiv"}>
                        <label className={"loginLabel"}>EIN: </label>
                        <input className={"loginInput"} onChange={handleEin} type={"text"}/>
                    </div>
                    <div className={"loginDiv"}>
                        <label className={"loginLabel"}>First name: </label>
                        <input className={"loginInput"} onChange={handleFirstName} type={"text"}/>
                    </div>
                    <div className={"loginDiv"}>
                        <label className={"loginLabel"}>Last name: </label>
                        <input className={"loginInput"} onChange={handleLastName} type={"text"}/>
                    </div>
                    <div className={"loginDiv"}>
                        <label className={"loginLabel"}>Password: </label>
                        <input className={"loginInput"} onChange={handlePassword} type={"password"}/>
                    </div>
                    <p className={signupError ? "errorMsg" : "successMsg"}>{signupError ? signupError : signupSuccess}</p>
                    <button className={"loginBtn"} type={"submit"}>Submit</button>
                </form>
            </div>
        </main>
    )
}
import {NavLink} from "react-router-dom";
import {useState} from "react";
import {useNavigate} from "react-router-dom";
export default function Login({setLoggedInUser}) {

    const [inputEin, setInputEin] = useState('');
    const [inputPassword, setInputPassword] = useState('');
    const [loginError, setLoginError] = useState("");
    const [loginSuccess, setLoginSuccess] = useState("");

    const navigate = useNavigate();

    function handleEin(event) {
        setInputEin(event.target.value);
        setLoginError("");
    }

    function handlePassword(event) {
        setInputPassword(event.target.value);
        setLoginError("");
    }

    function handleLogin(event) {
        event.preventDefault();
        const backendUrl = "/api";
        const cleanEin = inputEin.trim();

        const getUrl = `${backendUrl}/login`;

        const loginObj = {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                einNumber: cleanEin,
                password: inputPassword
            })
        };

        fetch(getUrl, loginObj)
            .then((response) => {
                if(!response.ok) {
                    // For failed login, set useState error
                    throw new Error("Incorrect EIN or Password");
                }
                return response.json();
            })
            .then((data) => {
                setLoggedInUser(data);
                setLoginError("");
                setLoginSuccess("Successful login");
                console.log(data);
                // Store token in local storage
                localStorage.setItem("jwt", data.jwtToken);
                localStorage.setItem("user", JSON.stringify({
                    firstName: data.firstName,
                    lastName: data.lastName
                }));
                // After successful login, display success msg and navigate to home after 3 seconds
                setTimeout(() => {
                    navigate("/");
                }, 2000);
            })
            .catch((error) => {
                setLoginError(error.message);
                console.error(error);
            })
    }


    return (
        <main>
            <h2>Login</h2>
            <div className={"loginContainer"}>
                <form onSubmit={handleLogin}>
                    <div className={"loginDiv"}>
                        <label className={"loginLabel"}>EIN: </label>
                        <input className={"loginInput"} onChange={handleEin} type={"text"}/>
                    </div>
                    <div className={"loginDiv"}>
                        <label className={"loginLabel"}>Password: </label>
                        <input className={"loginInput"} onChange={handlePassword} type={"password"}/>
                    </div>
                    <p className={loginError ? "errorMsg" : "successMsg"}>{loginError ? loginError : loginSuccess}</p>
                    <button className={"loginBtn"} type={"submit"}>Login</button>
                    <div id={"signUpLink"}>
                        <span>New User? </span>
                        <NavLink to={"/signup"}>Sign up</NavLink>
                    </div>
                </form>
            </div>
        </main>
    )
}
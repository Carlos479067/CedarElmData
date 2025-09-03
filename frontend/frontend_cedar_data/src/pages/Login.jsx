
export default function Login() {



    return (
        <main>
            <div className={"loginContainer"}>
                <form>
                    <div className={"loginDiv"}>
                        <label className={"loginLabel"}><h3>EIN: </h3></label>
                        <input className={"loginInput"} type={"text"}/>
                    </div>
                    <div className={"loginDiv"}>
                        <label className={"loginLabel"}><h3>Password: </h3></label>
                        <input className={"loginInput"} type={"password"}/>
                    </div>
                    <button className={"loginBtn"} type={"submit"}>Login</button>
                </form>
            </div>
        </main>
    )
}
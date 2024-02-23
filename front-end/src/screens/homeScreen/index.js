import { useState } from "react";
import { useNavigate } from "react-router-dom";

const STATIC_EMAIL = "nf@gmail.com";
const STATIC_PASSWORD = "123456";

const HomeScreen = () => {

    const navigation = useNavigate();
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState(false);
    const [warn, setWarn] = useState(false);
    const [good, setGood] = useState(false);

    const handleLogin = () => {
      console.log("Email, password", email, password);
      if(email !== '' && password !== '') {
        if(email == STATIC_EMAIL && password == STATIC_PASSWORD) {
          console.log("Good");
          setError(false);
          setWarn(false);
          setGood(true);
        } else {
          setError(true);
          setWarn(false);
          setGood(false);
        }
      } else {
        setWarn(true);
        setError(false);
        setGood(false);
      }
    };

    return(
        <main>
            <div class="container">
                <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
                    <div class="container">
                        <div class="row justify-content-center">
                            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
                                <div class="card mb-3">
                                    <div class="card-body">
                                        <div class="pt-4 pb-2">
                                            <h5 class="card-title text-center pb-0 fs-4">Login to Your Account</h5>
                                            {/* <p class="text-center small">Enter your username & password to login</p> */}
                                        </div>
                                        <div class="row g-3 needs-validation">
                                            <div class="col-12">
                                            <label for="yourUsername" class="form-label"></label>
                                            <div class="input-group has-validation">
                                              <input onChange={event => setEmail(event.target.value)} type="text" name="email" class="form-control" id="email" placeholder="Email" />
                                              <div class="invalid-feedback">
                                                Please enter your username
                                              </div>
                                            </div>
                                          </div>
                                          <div class="col-12">
                                            <label for="yourPassword" class="form-label"></label>
                                            <input onChange={event => setPassword(event.target.value)} type="password" name="password" class="form-control" id="yourPassword" placeholder="Password" />
                                            <div class="invalid-feedback">
                                              Please enter your password!
                                            </div>
                                          </div>
                                          <div class="col-12">
                                            <div class="form-check">
                                              <input class="form-check-input" type="checkbox" name="remember" value="true" id="rememberMe" />
                                              <label class="form-check-label" for="rememberMe">Remember me</label>
                                            </div>
                                          </div>
                                          <div class="col-12">
                                            <button class="btn btn-primary w-100" onClick={handleLogin}>Login</button>
                                          </div>
                                          {error ?
                                           <div className="col-12">
                                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                                Invalid email or Password !
                                              <button type="button" class="btn-close btn-close-white" data-bs-dismiss="alert" aria-label="Close"></button>
                                            </div>
                                          </div>
                                          :
                                          null
                                          }
                                          {warn ?
                                            <div className="col-12">
                                              <div class="alert alert-warning alert-dismissible fade show" role="alert">
                                                  Please enter email and password !
                                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                              </div>
                                            </div>
                                          :
                                          null
                                          }
                                          {good ?
                                            <div className="col-12">
                                              <div class="alert alert-success alert-dismissible fade show" role="alert">
                                                  Email & Password Correct !
                                                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                                              </div>
                                            </div>
                                          :
                                          null
                                          }
                                        </div>
                                    </div>
                                  </div>
                              </div>
                            </div>
                          </div>
                        </section>
                      </div>
                  </main>
    );
};

export default HomeScreen;
import {ResponseError} from "../generated-sources"

export class ErrorUtil {
    static retrieveErrorMessage(err: ResponseError, callback: any) {
        err.response.json().then(json => {
            if (json.detail) {
                callback(json.detail);
            } else if (json.message) {
                callback(json.message);
            } else {
                callback("Oeps, er is iets stuk gegaan, je moet Juriaan even bellen, dat is onze PO");
            }
        });
    }
}
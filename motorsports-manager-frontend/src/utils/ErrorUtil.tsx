import {ResponseError, ErrorResponse} from "../generated-sources"

export class ErrorUtil {
    static retrieveErrorMessage(err: ResponseError, callback: any) {
        err.response.json().then((json: ErrorResponse) => {
            if (json.detail) {
                callback(json.detail);
            } else if (json.title) {
                callback(json.title);
            } else {
                callback("Oeps, er is iets stuk gegaan, je moet Juriaan even bellen, dat is onze PO");
            }
        });
    }
}
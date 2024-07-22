import {ResponseError, ErrorResponse} from "../generated-sources"

export class ErrorUtil {
    static retrieveErrorMessage(err: ResponseError, callback: any) {
        if (!err.response) {
            callback({
                detail: "No response from backend."
            });
        } else {
            err.response.json().then((json: ErrorResponse) => {
                callback(json);
            });
        }
    }
}
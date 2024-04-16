module.exports = {
    hostRules: [
        {
            hostType: 'npm',
            matchHost: 'pkgs.dev.azure.com',
            username: 'apikey',
            password: process.env.RENOVATE_TOKEN,
        },
    ],
    repositories: ['SoftwareDevelopmentEngineerInTest/MotorsportsManager'],
};